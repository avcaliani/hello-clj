; QUICK START
; -------------------------

; Hello World \o/
(println "Hello World 🌎")

; Function
(defn hello-world
  "Says hello to someone"
  [name]
  (println "Hello" name "👋"))

(hello-world "anthony")

; Built-in functions
(+ 2 (* 4 3)) ; 14

; Adding an item into an array
(def colors ["red" "green"])
(def extended-colors (conj colors "blue"))
