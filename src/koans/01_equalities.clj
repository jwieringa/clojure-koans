(meditations
  "We shall contemplate truth by testing reality, via equality"
  (= true true)

  "To understand reality, we must compare our expectations against reality"
  (= 2 (+ 1 1))

  "You can test equality of many things"
  (= (+ 3 4) 7 (+ 2 5))

  "Some things may appear different, but be the same"
  (= true (= 2 2/1))

  "You cannot generally float to heavens of integers"
  ; This passes if blank, why?
  (= false (= 2 2.0))

  "But a looser equality is also possible"
  (= true (== 2.0 2))

  "Something is not equal to nothing"
  (= true (not (= 1 nil)))

  "Strings, and keywords, and symbols: oh my!"
  ; These things are not the same
  (= false (= "foo" :foo 'foo))

  "Make a keyword with your keyboard"
  (= :foo (keyword "foo"))

  "Symbolism is all around us"
  (= 'foo (symbol "foo"))

  "When things cannot be equal, they must be different"
  (not= :fill-in-the-blank :whatevs))
