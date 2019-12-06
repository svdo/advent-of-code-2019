(ns aoc.day2-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day2 :refer [input run-program apply-oppcode]]))

(deftest day2-test
  (testing "it terminates on opcode 99"
    (is (= [99] (run-program [99]))))

  (testing "it supports simple addition"
    (is (= [2, 0, 0, 0] (apply-oppcode [1, 0, 0, 0] 0))))

  (testing "it runs a program with a simple addition"
    (is (= [2, 0, 0, 0, 99] (run-program [1, 0, 0, 0, 99])))))
