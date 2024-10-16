(ns brew-bot.sampling.impl
  "The random number generating / sampling functionality of brew-bot.

   This namespace backs the functionality of the `brew-bot.sampling.api` namespace, and is not intended to be used directly.
   This functionality is not guaranteed to be stable, may change without notice, and makes no claims/guarantees about cryptographic security.
   If you are an external library consumer, please use truseted libraries for cryptographic security over this functionality."
  {:added                "3.4"
   :no-doc               true
   :implementation-only  true
   :not-for-external-use true})


(def max-unsigned-32-bit-int
  "The maximum unsigned 32-bit integer."
  (Math/pow 2 32))


(def max-signed-32-bit-int
  "The maximum signed 32-bit integer."
  (Math/pow 2 31))


(defn xor-shift
  "The xor-shift algorithm for 32-bit integers."
  [n]
  (-> n
      (bit-xor (bit-shift-left n 13))
      (bit-xor (unsigned-bit-shift-right n 17))
      (bit-xor (bit-shift-left n 5))
      (bit-and 0xffffffff)))


(defn next!
  "Returns the next long from the generator."
  [generator bits]
  (swap! generator xor-shift)
  (unsigned-bit-shift-right @generator (- 32 bits)))


(defprotocol WBRandom
  "A Protocol for random number generation.
   The `WB` prefix is shorthand for `Wall Brew` and is intended to prevent name collisions.
  Intended as a platform agnostic implementation of 32-bit Xorshift."

  (next-bitset!
    [generator bits]
    "Returns the next long from the generator."))


(deftype WBRandomGenerator
  [state]

  WBRandom

  (next-bitset!
    [_this bits]
    (next! state bits)))


(defn generate-seed
  "Generate a seed for the random number generator."
  []
  (rand-int max-signed-32-bit-int))


(defn ->generator
  "Create a new random number generator."
  ([]
   (->generator (generate-seed)))
  ([seed]
   (WBRandomGenerator. (atom (hash (str seed))))))


(defn next-double!
  "Returns the next double from the generator between 0.0 and 1.0.
   If no generator is provided, a new one is created and discarded.
   If a maximum value is provided, the value is scaled to that maximum."
  ([]
   (next-double! (->generator)))
  ([generator]
   (let [n (next-bitset! generator 32)]
     (double (/ n max-unsigned-32-bit-int))))
  ([generator max-value]
   (* max-value (next-double! generator))))


(defn next-int!
  "Returns the next integert from the generator between 0 and 2^32.
   If no generator is provided, a new one is created and discarded.
    If a maximum value is provided, the value is scaled to that maximum."
  ([]
   (next-int! (->generator)))
  ([generator]
   (next-bitset! generator 32))
  ([generator max-value]
   (int (* max-value (next-double! generator)))))


(defn apply-weight
  "Apply a weight function to a value.
   The weight function must return a non-negative value.
   The function returns a vector of the total weight and the value.

   For example:
   ```clj
   (apply-weight inc 1)
   ; => [2 1] ;; (inc 1)
   ```
   In the above example, the first element of the vector is the total weight of the value, and the second element is the value itself."
  [weight-fn [total-weight previous-value] value]
  (let [weight (weight-fn value)]
    (cond
      (pos? weight)  [(+ total-weight weight) value]
      (zero? weight) [total-weight previous-value]
      :else          (throw (ex-info "Weight function must return a non-negative value" {:value value})))))


(defn apply-weights
  "Apply a weight function to a collection of values.
   The weight function must return a non-negative value.
   The function returns a sorted map of the current weight and values.

   For example:
   ```clj
   (apply-weights inc [1 2 3 4 5])
   ; => {2 1,  ;; (inc 1)
         5 2,  ;; (+ (inc 2) (inc 1))
         9 3,  ;; (+ (inc 3) (inc 2) (inc 1))
         14 4, ;; (+ (inc 4) (inc 3) (inc 2) (inc 1))
         20 5} ;; (+ (inc 5) (inc 4) (inc 3) (inc 2) (inc 1))
   ```
   In the above example, the keys are the total weight of the values up to that point, and the values are the values themselves."
  [weight-fn coll]
  (->> (reductions (partial apply-weight weight-fn) [0] coll)
       next
       (into (sorted-map))))
