(defun factorial (n)

(if (zerop n)
1
(* n (factorial (- n 1)))))

(print (factorial 5))i
