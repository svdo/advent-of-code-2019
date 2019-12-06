(ns aoc.day3-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day3 :refer [input parse-line]]))

(deftest day3-test
  (testing "it can parse input"
    (is (= [[:right 1001] [:down 890] [:right 317] [:up 322]]
           (parse-line "R1001,D890,R317,U322")))))
