(ns aoc.day3
  (:require [clojure.string :as str]))


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
