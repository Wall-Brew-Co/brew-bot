(ns brew-bot.sampling.api
  (:require [brew-bot.sampling.impl :as impl]))


(def ^:dynamic ^:private
  *global-generator*
  "A thread-local random number generator."
  nil)


(defmacro with-seed
  "Execute `body` with a seed for the internal random generator over the scope of the `body`.
   Note, this is a dynamic var and will only affect the current thread.

   This reuses the same generator for the duration of the execution of body, allowing multiple calls to `sample` and `weighted-sample` to be reproducible.
   If a seed is already set for `sample` or `sample-weighted`, it will be replaced for the duration of the execution of `body`.

   For example:
   ```clj
   (with-seed 12
     (apply str (take 25 (sut/sample \"abcde\"))) ;=> \"caaebcdeccabaaccaeeabdbcd\"
     (apply str (take 25 (sut/sample 2 \"fghij\"))) ;=> \"jhihffggjjjhijgjjjjghjfji\")
   ```"
  [seed & body]
  `(binding [*global-generator* (impl/->generator ~seed)]
     ~@body))


(defn sample
  "Returns a lazy sequence of samples from `coll` using an internal random generator.
   Requires that `coll` is a finite, countable collection that can be realized.
   If `coll` is empty, an empty sequence is returned.
   A seed can be provided to create reproducible sequences, otherwise a random seed is used.

   Examples:

   ```clj
   (take 5 (sample 1 \"abcde\"))
   ; => (\\a \\e \\b \\d \\a)

   (take 3 (sample \"hello\" (range 99)))
   ; => (6 97 18)
   ```

   `coll` can be:
      - a vector
      - a list
      - a finite lazy sequence
      - a set
      - a hashmap
      - a string

   `seed` can be any value that can be cast to a string."
  ([coll]
   (if (seq coll)
     (sample impl/generate-seed coll)
     '()))
  ([seed coll]
   (assert (seqable? coll) "`coll` must be a finite, countable collection")
   (if (seq coll)
     (let [coll'     (if (vector? coll) coll (vec (seq coll)))
           generator (or *global-generator* (impl/->generator seed))
           size      (count coll')]
       (repeatedly #(nth coll' (impl/next-int! generator size))))
     '())))


(defn weighted-sample
  "Returns a lazy sequence of samples from `coll` using an internal random generator, selecting each item `i` with a probability of `(weight-fn i)`.
   Requires that `coll` is a finite, countable collection that can be realized.
   If `coll` is empty, an empty sequence is returned.
   `weight-fn` must be a function that takes an item from `coll` and returns a non-negative probability weight.

   A seed can be provided to create reproducible sequences, otherwise a random seed is used.

   Examples:

   ```clj
   (take 3 (weighted-sample inc (range 99)))
   ; => (16 92 91)

   (first (weighted-sample (fn [x] (if (even? x) 1 0)) [1 2 3 4 5 6 7 8 9 10]))
   ; => 2

   (-> (weighted-sample :score [{:name \"Alice\" :score 10}
                                {:name \"Bob\" :score 20}
                                {:name \"Charlie\" :score 30}])
       first
       :name)
   ```

   `coll` can be:
      - a vector
      - a list
      - a finite lazy sequence
      - a set
      - a hashmap
      - a string

   `seed` can be any value that can be cast to a string."
  ([weight-fn coll]
   (if (seq coll)
     (weighted-sample impl/generate-seed weight-fn coll)
     '()))
  ([seed weight-fn coll]
   (assert (seqable? coll) "`coll` must be a finite, countable collection")
   (assert (ifn? weight-fn) "`weight-fn` must implement IFn.")
   (if (seq coll)
     (let [coll'                 (if (vector? coll) coll (vec (seq coll)))
           generator             (or *global-generator* (impl/->generator seed))
           incremental-weighting (impl/apply-weights weight-fn coll')
           total-weight          (first (last incremental-weighting))]
       (repeatedly #(second (first (subseq incremental-weighting > (impl/next-double! generator total-weight))))))
     '())))
