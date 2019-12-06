(ns aoc.day2-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day2 :refer [input run-program]]))

(deftest day2-test
  (testing "it terminates on opcode 99"
    (is (= [99] (run-program [99]))))

  (testing "it runs a program with a simple operation"
    (is (= [2, 0, 0, 0, 99] (run-program [1, 0, 0, 0, 99])))
    (is (= [2, 3, 0, 6, 99] (run-program [2, 3, 0, 3, 99])))
    (is (= [2, 4, 4, 5, 99, 9801] (run-program [2, 4, 4, 5, 99, 0])))))
