(ns prime-table.core-test
  (:require [clojure.test :refer :all]
            [prime-table.core :refer :all]))

(deftest functional-or
  (testing "Checking that 'or*' works as expected"
    (is (= true (or* [true false])))))

(deftest ten-first-primes
  (testing "Checking the quality of the prime generator"
    (is (= [2 3 5 7 11 13 17 19 23 29] (primes 10)))))

(deftest one-is-added-to-indexed-primes
  (testing "Checking that [0 1] is at the beginning of
            indexed-primes results, because its needed to
            print the primes themselves"
    (is (= [0 1] (first (indexed-primes 0))))))

(deftest travel-correctness
  (testing "Checking that 'travel' gives the coordinates
            and prime multiplications"
    (is (= [[0 0 1] [1 0 2] [1 1 4]] (travel 1)))))

(deftest multiplication-matrix-population
  (testing "Checking that the multiplication matrix is generated correctly"
    (is (= [[1 2 3] [2 4 6] [3 6 9]]
           (populate-matrix 2)))))

(deftest line-printer-quality
  (testing "Checking the quality of the vector stringifyer"
    (is (= "1\t2\t3" (line-string [1 2.0 3])))))
