;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

;; What is the 10 001st prime number?

(letfn [(mods [n]
          (map #(mod n %)
               (range 2 (inc (Math/sqrt n)))))]
  (nth (cons 2
             (remove #(apply (some-fn zero?) (mods %))
                     (iterate #(+ % 2) 3)))
       10000))

;; Answer: 104743
