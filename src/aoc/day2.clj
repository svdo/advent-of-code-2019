(ns aoc.day2)

(def input
  [1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 13, 1, 19, 1, 10, 19, 23
   1, 6, 23, 27, 1, 5, 27, 31, 1, 10, 31, 35, 2, 10, 35, 39, 1, 39, 5, 43, 2
   43, 6, 47, 2, 9, 47, 51, 1, 51, 5, 55, 1, 5, 55, 59, 2, 10, 59, 63, 1, 5
   63, 67, 1, 67, 10, 71, 2, 6, 71, 75, 2, 6, 75, 79, 1, 5, 79, 83, 2, 6, 83
   87, 2, 13, 87, 91, 1, 91, 6, 95, 2, 13, 95, 99, 1, 99, 5, 103, 2, 103, 10
   107, 1, 9, 107, 111, 1, 111, 6, 115, 1, 115, 2, 119, 1, 119, 10, 0, 99, 2
   14, 0, 0])

(def instruction
  {1  :add
   99 :terminate})

(defn op-arg [program pc]
  (fn [offset]
    (let [index-of-lhs (program (+ pc offset))]
      (program index-of-lhs))))

(defn op-lhs [program pc]
  ((op-arg program pc) 1))

(defn op-rhs [program pc]
  ((op-arg program pc) 2))

(def instruction
  {1  :add
   99 :terminate})

(defn apply-add [program pc]
  (let [lhs (op-lhs program pc)
        rhs (op-rhs program pc)
        output-index (program (+ pc 3))]
    (assoc program output-index (+ lhs rhs))))

(defmulti apply-oppcode
  (fn [program pc]
    (instruction (program pc))))

(defmethod apply-oppcode :add [program pc] (apply-add program pc))
(defmethod apply-oppcode :terminate [program _] program)

(defn run-program
  ([program]
   (run-program program 0))
  ([program pc]
   (apply-oppcode program pc)))
