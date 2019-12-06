(ns aoc.day1-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day1 :refer [input module-fuel total-fuel-requirement
                              module-fuel-with-fuel-mass
                              total-fuel-requirement-with-fuel-mass]]))

(deftest day1-test
  (testing "Part one: Fuel calculation"
    (is (= 2 (module-fuel 12)))
    (is (= 2 (module-fuel 14)))
    (is (= 654 (module-fuel 1969)))
    (is (= 33583 (module-fuel 100756))))

  (testing "Part one: Total fuel requirement"
    (is (= 4 (total-fuel-requirement [12 14])))
    (is (= 658 (total-fuel-requirement [12 14 1969])))
    (is (= 3538016 (total-fuel-requirement input))))

  (testing "Part two: Taking fuel into account"
    (is (= 2 (module-fuel-with-fuel-mass 14)))
    (is (= 966 (module-fuel-with-fuel-mass 1969)))
    (is (= 50346 (module-fuel-with-fuel-mass 100756))))

  (testing "Part two: Total fuel requirement"
    (is (= 5304147 (total-fuel-requirement-with-fuel-mass input)))))
