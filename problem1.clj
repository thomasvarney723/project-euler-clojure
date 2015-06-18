(defn div3or5? [x]
  (if (or (zero? (mod x 3))
          (zero? (mod x 5)))
      x
      false))

(def multiples (filter number? (map div3or5? (range 1000))))

(reduce + multiples)
