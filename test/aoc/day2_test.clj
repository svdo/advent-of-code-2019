(ns aoc.day2-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day2 :refer [input run-program restore-1202 find-noun-and-verb]]))

(deftest day2-test
  (testing "it terminates on opcode 99"
    (is (= [99] (run-program [99]))))

  (testing "it runs a program with a simple operation"
    (is (= [2, 0, 0, 0, 99] (run-program [1, 0, 0, 0, 99])))
    (is (= [2, 3, 0, 6, 99] (run-program [2, 3, 0, 3, 99])))
    (is (= [2, 4, 4, 5, 99, 9801] (run-program [2, 4, 4, 5, 99, 0]))))

  (testing "it runs a program with two operations"
    (is (= [30, 1, 1, 4, 2, 5, 6, 0, 99] (run-program [1, 1, 1, 4, 99, 5, 6, 0, 99]))))

  (testing "restore-1202"
    (is (= [0, 12, 2, 0, 0] (restore-1202 [0, 0, 0, 0, 0]))))

  (testing "part 1"
    (is (= 5482655 (first (run-program (restore-1202 input))))))

  (testing "part 2"
    (let [[noun verb] (find-noun-and-verb input)]
      (is (= 4967 (-> noun (* 100) (+ verb)))))))
