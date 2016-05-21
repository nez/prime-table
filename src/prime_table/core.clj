(ns prime-table.core
  (:require [clojure.core.matrix :refer :all]
            [clojure.core.matrix.operators :as mo]
            [clojure.string :as s]))

(defn or*                               ;found this fn on SO
  "Apply 'or' to a list of predicates"  ; I use it a lot because u cant do
  [coll]                                ; (apply or [true true])
  (if-let [t? (some true? coll)]
    true
    false))

(defn is-prime?
  "Is this a prime number?, based on previous primes"
  [n prev-primes]
  (not (or* (map #(= 0 (mod n %))       ;If n mod x = 0, for x any previous prime,
                 prev-primes))))        ; then this aint no prime

(defn primes
  "The first n primes"
  [n]
  (loop [bag []                         ;bag o' primes
         counter n                      ;how many primes we've got
         pointer 2]                     ;next number to check
    (if (= counter 0)
      bag
      (if (is-prime? pointer bag)
        (recur (conj bag pointer)
               (dec counter)
               (inc pointer))
        (recur bag
               counter
               (inc pointer))))))

(defn indexed-primes
  "Generate a list of vectors where the first elements
  are a sequence of whole numbers and the second elements
  are a sequence of primes.
  The first element is [0 1]. We are aware that 1 is not prime
  but it will help afterwars because we want to print the primes in
  the first column and row, so we will multiply them by 1"
  [n]
  (map #(vector %1 %2)
       (range)
       (concat [1] (primes n))))

(defn travel
  "Generate a list of vectors, where each vector contains
  two coordinates and the values (the multiplication of the
  corresponding primes)
  Note that we are only traveling half of the matrix, because
  it is symmetric"
  [n]
  (let [les-primes (indexed-primes n)]
    (for [[x1 y1] les-primes
          [x2 y2] les-primes
          :when (>= x1 x2)]             ;we only travel half of the matrix
      [x1 x2 (* y1 y2)])))

(defn symmetric-mset
  "Add 'val' to 'x,y' and 'y,x'"
  [M x y val]
  (mset (mset M x y val) y x val))

(defn populate-matrix
  "Generate a n+1 * n+1 matrix with the multiplication
  table of the first n primes"
  [n]
  (loop [M (zero-matrix (inc n) (inc n));the matrix is larger because we also store
         coll (travel n)]               ; the primes themselves, it is easier to print
    (if (empty? coll)                   ; the header row and colum this way
      M
      (let [[x1 x2 y] (first coll)]
        (recur (symmetric-mset M x1 x2 y)
               (rest coll))))))

(defn line-string
  "Pretty print a vector of numbers
  casting them to integers"
  [coll]
  (s/join "\t" (map int coll)))

(defn print-matrix
  "Pretty print a matrix or any collection of collections"
  [m]                                   ;the first '1' in the matrix is implementation, wont print it
  (println
   (s/replace-first (s/join "\n" (map line-string m))
                    #"1"
                    " ")))

(defn primes-multiplication-table
  "Print a multiplication table of the first n primes"
  ([]
   (primes-multiplication-table 10))
  ([n]
   (print-matrix (populate-matrix n))))

(defn -main
  "Generate da prime multiplication table"
  []
  (primes-multiplication-table))       ;the use case is to print a 10 x 10 table
