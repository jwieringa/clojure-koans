; Evalutes, if not nil or false, yeilds then. Otherwise yields then
(defn is-even? [n]
  (if (= n 0)
    true
    (not (is-even? (dec n)))))

; (is-even? 0) ==> (= 0 0)
;              ==> true
;
; (is-even? 1) ==> (not (is-even? (dec 1))
;              ==> (not (is-even? 0))
;              ==> (not (= 0 0))
;              ==> (not true)
;              ==> false
;
; (is-even? 2) ==> (not (is-even? (dec 2)))
;              ==> (not (is-even? 1))
;              ==> (not (not is-even? (dec 1))
;              ==> (not (not is-even? 0)
;              ==> (not (not true)
;              ==> (not (false)
;              ==> (true)
;
; (is-even? 3) ==> (not (is-even? (dec 3))
;              ==> (not (is-even? 2)
;              ==> (not (not is-even? (dec 2))
;              ==> (not (not is-even? 1))
;              ==> (not (not (not is-even? (dec 1))))
;              ==> (not (not (not is-even? 0)))
;              ==> (not (not (not (= 0 0))))
;              ==> (not (not (false)))
;              ==> (not (true))
;              ==> (false)
;
;; And taking shortcuts...
;
; (is-even? 4) ==> (not (is-even? 3)
;              ==> (not (not is-even? 2))
;              ==> (not (not (not is-even? 1)))
;              ==> (not (not (not (not is-even? 0))))
;              ==> (not (not (not (not (= 0 0)))))
;              ==> (not (not (not (not (true)))))
;              ==> (not (not (not (false))))
;              ==> (not (not (true)))
;              ==> (not (false))
;              ==> (true)

(defn is-even-bigint? [n]
  (loop [n n
         acc true]
    (if (= n 0)
      acc
      (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
  (loop [coll coll
         reversed ()]
    (if (empty? coll)
      reversed
      (recur (rest coll) (cons (first coll) reversed)))))

(defn factorial [n]
  (loop [n n
         acc 1]
    (if (= 0 n)
      acc
      (recur (dec n) (* n acc)))))

; Since solving the fib sequence is finite in these meditaitons,
; using recur is probably a good solution. However, if it were
; a infinite sequence, a lazy sequence should be used. fib-step
; and fib-seq use lazy sequences to solve for a finite fib, but
; does demonstrate the pattern.
;
; (defn fib-step [[a b]]
;     [b (+ a b)])
;
; (defn fib-seq []
;     ; key to this pattern is map and iterate.
;     ; both return a lazy sequence meaning that they are only
;     ; evaluated when necessary instead of upon a function call
;     (map first (iterate fib-step [0 1])))

(meditations
  "Recursion ends with a base case"
  (= true (is-even? 0))

  "And starts by moving toward that base case"
  (= false (is-even? 1))

  "Having too many stack frames requires explicit tail calls with recur"
  (= false (is-even-bigint? 100003N))

  "Reversing directions is easy when you have not gone far"
  (= '(1) (recursive-reverse [1]))

  "Yet it becomes more difficult the more steps you take"
  (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))

  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (< 1000000000000000000000000N (factorial 1000N))

  "But what happens when the machine limits you?"
  (< 1000000000000000000000000N (factorial 100003N)))
