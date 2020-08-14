(ns brew-bot.util
  "Common fns required across brew-bot")

(defn max-n-kv
  "Given `m` with k-v pairs for which all values are numbers, return the `n` k-v pairs with the highest values"
  [m n]
  (let [ordered-tuples (take n (sort-by (comp - last) m))
        list-of-maps   (map #(hash-map (first %) (second %)) ordered-tuples)]
    (apply merge list-of-maps)))

(defn min-n-kv
  "Given `m` with k-v pairs for which all values are numbers, return the `n` k-v pairs with the lowest values"
  [m n]
  (let [ordered-tuples (take n (sort-by last m))
        list-of-maps   (map #(hash-map (first %) (second %)) ordered-tuples)]
    (apply merge list-of-maps)))

(defn fermentables->cbf-fermentables
  "Given a vector of common-beer-format conforming ::fermentable maps, convert them to a ::fermentables record"
  [fermentables]
  (map #(hash-map :fermentable %) fermentables))

(defn hops->cbf-hops
  "Given a vector of common-beer-format conforming ::hop maps, convert them to a ::hops record"
  [hops]
  (map #(hash-map :hop %) hops))

(defn yeast->cbf-yeasts
  "Given a vector of common-beer-format conforming ::yeast maps, convert them to a ::yeasts record"
  [yeasts]
  (map #(hash-map :yeast %) yeasts))
