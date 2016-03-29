;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

;; Find the sum of all the primes below two million.

(letfn [(primes-below [n]
          (remove (set (mapcat #(range (* % %) n %)
                               (range 3 (Math/sqrt n) 2)))
                  (cons 2 (range 3 n 2))))]
  
  (reduce + (primes-below 2000000)))

;; Answer: 142913828922
