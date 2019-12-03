(ns aoc.day1-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day1 :refer [calculate-fuel]]))

(deftest day1-test
  (testing "Fuel calculation"
    (is (= 2 (calculate-fuel 12)))))
