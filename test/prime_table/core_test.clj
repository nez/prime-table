(ns prime-table.core-test
  (:require [clojure.test :refer :all]
            [prime-table.core :refer :all]))

(deftest ten-first-primes
  (testing "Checking the quality of the prime generator"
    (is (= [2 3 5 7 11 13 17 19 23 29] (primes 10)))))

(deftest line-printer-quality
  (testing "Checking the quality of the vector stringifyer"
    (is (= "1\t2\t3" (line-string [1 2.0 3])))))
