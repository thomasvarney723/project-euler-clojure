; Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:

; 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

; By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.

;; (fib) copied from Clojure documentation :(
(defn fib [a b] (cons a (lazy-seq (fib b (+ b a)))))

(reduce + (filter even? (take-while #(< % 4000000) (fib 1 2))))

;; Answer: 4613732