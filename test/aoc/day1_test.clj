(ns aoc.day1-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day1 :refer [input module-fuel total-fuel-requirement]]))

(deftest day1-test
  (testing "Part one: Fuel calculation"
    (is (= 2 (module-fuel 12)))
    (is (= 2 (module-fuel 14)))
    (is (= 654 (module-fuel 1969)))
    (is (= 33583 (module-fuel 100756))))

  (testing "Part one: Total fuel requirement"
    (is (= 4 (total-fuel-requirement [12 14])))
    (is (= 658 (total-fuel-requirement [12 14 1969])))
    (is (= 3538016 (total-fuel-requirement input)))))
