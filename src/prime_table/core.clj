(ns prime-table.core
  (:require [clojure.core.matrix :refer :all]
            [clojure.core.matrix.operators :as mo]
            [clojure.string :as s]))

(defn or*                               ;found this on SO
  "Apply 'or' to a list of predicates"  ;I use it a lot because u cant do
  [coll]                                ;(apply or [true true])
  (if-let [t? (some true? coll)]
    true
    false))

(defn is-prime?
  "Is this a prime number?, based on previous primes"
  [n prev-primes]
  (not (or* (map #(= 0 (mod n %))     ;If n mod x = 0, for x all previous primes,
                 prev-primes))))      ;then this aint no prime

(defn primes
  "The first n primes"
  [n]
  (loop [bag []
         counter n
         pointer 2]
    (if (= counter 0)
      bag
      (if (is-prime? pointer bag)
        (recur (conj bag pointer)
               (dec counter)
               (inc pointer))
        (recur bag
               counter
               (inc pointer))))))

(set-current-implementation :vectorz)

(defn indexed-primes
  [n]
  (map #(vector %1 %2) (range) (concat [1] (primes n))))

(defn travel
  [n]
  (let [les-primes (indexed-primes n)]
    (for [[x1 y1] les-primes
          [x2 y2] les-primes
          :when (>= x1 x2)]
      [x1 x2 (* y1 y2)])))

(defn symmetric-mset
  [M x y val]
  (mset (mset M x y val) y x val))

(defn populate-matrix
  [n]
  (loop [M (zero-matrix (inc n) (inc n))
         coll (travel n)]
    (if (empty? coll)
      M
      (let [[x1 x2 y] (first coll)]
        (recur (symmetric-mset M x1 x2 y)
               (rest coll))))))

(defn rng [n]
  (range (inc n)))

(defn symmetric-mset!
  [M x y val]
  (do (mset! M x y val)
      (mset! M y x val)))

;(
(defn def-zero-matrix
  [n]
  (def M (zero-matrix n n)))

(defn populate-matrix
  [M X]
  (map (fn [x1 y1] (map (fn [x2 y2] (symmetric-mset! M x1 x2 (* y1 y2)))
                          (rng x1)
                          X))
         (rng (dec (count X)))
         X))

(defn multiplication-matrix
  [n]
  (do
    (def M (zero-matrix (inc n) (inc n)))
    (populate-matrix M (concat [1] (primes n)))
    M))
;)
(defn multiplication-matrix
  [n]
  (loop [M (zero-matrix (inc n) (inc n))
         ]))

(defn line-string
  [coll]
  (s/join "\t" (map int coll)))

(defn print-matrix
  [m]
  (println (s/replace-first (s/join "\n" (map line-string m)) #"1" " ")))

(defn -main []
  (print-matrix (multiplication-matrix 10)))
