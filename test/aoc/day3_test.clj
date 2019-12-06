(ns aoc.day3-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day3 :refer [input parse-line expand-step expand-steps]]))

(deftest day3-test
  (testing "it can parse input"
    (is (= [[:right 1001] [:down 890] [:right 317] [:up 322]]
           (parse-line "R1001,D890,R317,U322"))))

  (testing "it can expand one step to set of coordinates"
    (is (= #{[1 0] [2 0] [3 0]} (expand-step [0 0] [:right 3])))
    (is (= #{[-1 0] [-2 0] [-3 0]} (expand-step [0 0] [:left 3])))
    (is (= #{[0 1] [0 2] [0 3]} (expand-step [0 0] [:up 3])))
    (is (= #{[0 -1] [0 -2] [0 -3]} (expand-step [0 0] [:down 3])))
    (is (= #{[2 1] [2 0] [2 -1]} (expand-step [2 2] [:down 3]))))

  (testing "it can expand multiple steps to set of coordinates"
    (is (= #{} (expand-steps [0 0] [])))
    (is (= #{[1 0] [1 -1] [2 -1] [3 -1] [4 -1]}
           (expand-steps [1 1] [[:down 2] [:right 3]])))
    (is (= #{[1 0] [1 -1] [2 -1] [3 -1] [4 -1] [0 -1] [0 0] [0 1]}
           (expand-steps [1 1] [[:down 2] [:right 3] [:left 4] [:up 2]])))))
