(ns aoc.day2)

(def input
  [1, 0, 0, 3, 1, 1, 2, 3, 1, 3, 4, 3, 1, 5, 0, 3, 2, 13, 1, 19, 1, 10, 19, 23
   1, 6, 23, 27, 1, 5, 27, 31, 1, 10, 31, 35, 2, 10, 35, 39, 1, 39, 5, 43, 2
   43, 6, 47, 2, 9, 47, 51, 1, 51, 5, 55, 1, 5, 55, 59, 2, 10, 59, 63, 1, 5
   63, 67, 1, 67, 10, 71, 2, 6, 71, 75, 2, 6, 75, 79, 1, 5, 79, 83, 2, 6, 83
   87, 2, 13, 87, 91, 1, 91, 6, 95, 2, 13, 95, 99, 1, 99, 5, 103, 2, 103, 10
   107, 1, 9, 107, 111, 1, 111, 6, 115, 1, 115, 2, 119, 1, 119, 10, 0, 99, 2
   14, 0, 0])

(defn op-arg [program ip]
  (fn [offset]
    (let [index-of-lhs (program (+ ip offset))]
      (program index-of-lhs))))

(defn op-lhs [program ip]
  ((op-arg program ip) 1))

(defn op-rhs [program ip]
  ((op-arg program ip) 2))

(def opcode->op
  {1  :add
   2  :multiply
   99 :terminate})

(defn apply-binary-operation [program ip operation]
  (let [lhs (op-lhs program ip)
        rhs (op-rhs program ip)
        output-index (program (+ ip 3))]
    (assoc program output-index (operation lhs rhs))))

(defn apply-add [program ip]
  (apply-binary-operation program ip +))

(defn apply-multiply [program ip]
  (apply-binary-operation program ip *))

(defn run-program
  ([program] (run-program program 0))

  ([program ip]
   (let [instruction-size 4]
     (case (opcode->op (program ip))
       :add
       (-> program
           (apply-add ip)
           (recur (+ ip instruction-size)))

       :multiply
       (-> program
           (apply-multiply ip)
           (recur (+ ip instruction-size)))

       :terminate program))))

(defn restore-1202 [program]
  (-> program
      (assoc 1 12)
      (assoc 2 2)))
