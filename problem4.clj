;; A palindromic number reads the same both ways. The largest palindrome made
;; from the product of two 2-digit numbers is 9009 = 91 * 99.

;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [n]
  (= (str n)
     (clojure.string/reverse (str n))))

(defn permutations
  ([n] (permutations 1 n))
  ([limit n]  ;; optional lower-limit for efficiency
   (->> (for [x (range limit (inc n))
              y (range limit (inc n))]
          (* x y))
        (sort-by identity >)  ;; sort in descending order
        (filter palindrome?)
        first)))

;; Answer: 906609
;; 993 * 913

;; I really wanted to build a fn that lazily computed products in descending
;; order. I wasn't able to achieve this and don't know how to go about googling
;; for it. I suspect there's a mathematical term for it. For this reason
;; permutations takes an optional 'limit' that cuts the size of the search space.
;; '(permutations 900 999)' returns the correct answer and is ~3000x faster.
