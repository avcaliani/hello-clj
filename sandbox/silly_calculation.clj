(import 'java.time.LocalTime)

; Non-pure Function
(defn silly-calculation
  "multiply or add, depending on the time of day"
  [a b]
  (let [now (LocalTime/now)]
    (if (< (.getHour now) 12)
      (* a b)
      (+ a b))))

(silly-calculation 2 3) ; 6 or 5


; Pure Function
(defn pure-silly-calculation
  "multiply or add, depending on the time you pass"
  [a b time]
  (if (< (.getHour time) 12)
    (* a b)
    (+ a b)))

(pure-silly-calculation 2 3 (LocalTime/now))