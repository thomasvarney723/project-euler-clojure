;; A palindromic number reads the same both ways. The largest palindrome made
;; from the product of two 2-digit numbers is 9009 = 91 * 99.

;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [n]
  (let [s (str n)]
    (= s (clojure.string/reverse (str n)))))

(defn max-palindrome-product
  "Two-arity is buggy. (max-palindrome-product 920 999) ;=> 888888"
  ([n] (max-palindrome-product 1 n))
  ([lower-limit n]  ;; optional lower-limit for efficiency
   (let [factors (range lower-limit (inc n))]
     (->> (for [x factors y factors
                :let [x*y (* x y)]
                :when (palindrome? x*y)]
            x*y)
          (apply max)))))

(max-palindrome-product 999) 

;; Answer: 906609
;; 993 * 913

;; I really wanted to build a fn that lazily computed products in descending
;; order. I wasn't able to achieve this and don't know how to go about googling
;; for it. I suspect there's a mathematical term for it. For this reason
;; permutations takes an optional 'limit' that cuts the size of the search space.
;; '(permutations 900 999)' returns the correct answer and is ~150x faster.
