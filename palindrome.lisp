

(defun palindrome(input)
  (cond ((null input) t)
    ((not(equal(first(reverse input))(first input))) nil)
    (t(palindrome(last(rest(reverse input)))))))



(write(palindrome'(a b b a)))
(terpri)
(write(palindrome '(a b c b a)))
(terpri)
(write(palindrome '(a b c)))
(terpri)
(write(palindrome '(a (d e) b (d e) a)))
(terpri)
(write(palindrome '(a (d e) b (e d) a)))
~
