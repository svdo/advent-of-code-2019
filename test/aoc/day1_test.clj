(ns aoc.day1-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day1 :refer [input calculate-fuel total-fuel-requirement]]))

(deftest day1-test
  (testing "Fuel calculation"
    (is (= 2 (calculate-fuel 12)))
    (is (= 2 (calculate-fuel 14)))
    (is (= 654 (calculate-fuel 1969)))
    (is (= 33583 (calculate-fuel 100756))))

  (testing "Total fuel requirement"
    (is (= 4 (total-fuel-requirement [12 14])))
    (is (= 658 (total-fuel-requirement [12 14 1969])))
    (is (= 3538016 (total-fuel-requirement input)))))
