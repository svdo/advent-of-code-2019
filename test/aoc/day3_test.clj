(ns aoc.day3-test
  (:require [clojure.test :refer [deftest testing is]]
            [aoc.day3 :refer [input parse-line expand-step expand-steps
                              closest-to-origin intersections]]))

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
           (expand-steps [1 1] [[:down 2] [:right 3] [:left 4] [:up 2]]))))

  (testing "it can determine how far closest coordinate to origin is"
    (is (= 5 (closest-to-origin #{[5 3] [3 2] [-8 1]}))))

  (testing "it can determine intersections of two paths"
    (is (= #{[3 3] [6 5]}
           (intersections [[:right 8] [:up 5] [:left 5] [:down 3]]
                          [[:up 7] [:right 6] [:down 4] [:left 4]]))))

  (testing "it can determine distance of closest intersection"
    (is (= 6
           (closest-to-origin
            (intersections [[:right 8] [:up 5] [:left 5] [:down 3]]
                           [[:up 7] [:right 6] [:down 4] [:left 4]]))))
    (is (= 159 (closest-to-origin
                (intersections (parse-line "R75,D30,R83,U83,L12,D49,R71,U7,L72")
                               (parse-line "U62,R66,U55,R34,D71,R55,D58,R83")))))
    (is (= 135 (closest-to-origin
                (intersections (parse-line "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51")
                               (parse-line "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7"))))))

  (testing "part 1"
    (is (= 352 (closest-to-origin (apply intersections input))))))
