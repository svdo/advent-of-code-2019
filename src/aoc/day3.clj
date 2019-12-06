(ns aoc.day3
  (:require [clojure.string :as str]
            [clojure.set :refer [union]]))


;;
;; Read and Parse Input
;;


(defn read-file-lines [name]
  (with-open [rdr (clojure.java.io/reader name)]
    (reduce conj [] (line-seq rdr))))

(def ->direction
  {\U :up
   \R :right
   \D :down
   \L :left})

(defn parse-step [step]
  [(->direction (first step)) (Integer. (apply str (next step)))])

(defn parse-line [line]
  (map parse-step (str/split line #",")))

(def input
  (->> (read-file-lines "resources/day3.txt")
       (map parse-line)))

;;
;; Part 1
;;

(def axis {:left :x :right :x :up :y :down :y})

(defmulti expand-step (fn [_ [direction _]] (axis direction)))
(defmethod expand-step :x [[x y] [direction length]]
  (let [x-multiplier (case direction
                       :left -1
                       :right 1)]
    (into #{} (map (fn [x] [x y]) (range (+ x (* x-multiplier 1))
                                         (+ x (* x-multiplier (inc length)))
                                         x-multiplier)))))
(defmethod expand-step :y [[x y] [direction length]]
  (let [y-multiplier (case direction
                       :down -1
                       :up 1)]
    (into #{} (map (fn [y] [x y]) (range (+ y (* y-multiplier 1))
                                         (+ y (* y-multiplier (inc length)))
                                         y-multiplier)))))

(defmulti move (fn [_ [direction _]] direction))
(defmethod move :up [[x y] [_ length]] [x (+ y length)])
(defmethod move :down [[x y] [_ length]] [x (- y length)])
(defmethod move :right [[x y] [_ length]] [(+ x length) y])
(defmethod move :left [[x y] [_ length]] [(- x length) y])

(defn expand-steps [from steps]
  (if (seq steps)
    (let [step (first steps)]
      (union (expand-step from step)
             (expand-steps (move from step) (next steps))))
    #{}))
