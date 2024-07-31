;; --------------------------
;; QUICK START
;; --------------------------
;; The following code was created to be executed locally in a REPL.
;; Option 1: Online at "https://tryclojure.org"
;; Option 2: Local, on your terminal execute "clj"

;; Hello World \o/
(println "Hello World 🌎")

;; Function
(defn hello-world
 "Says hello to someone"
 [name]
 (println "Hello" name "👋"))

(hello-world "joe")


;; --------------------------
;; Lambda Function
;; --------------------------
(fn [name] (str "Hello " name " from a Lambda λ"))
;; or
#(str (str "Hello " %1 " from a Lambda λ"))
;; At use 👇
(map
#(str (str "Hello " %1 " from a Lambda λ"))
["joe" "nina" "book"])


;; --------------------------
;; Built-in functions
;; --------------------------
(+ 2 (* 4 3)) ;; 14

;; Adding an item into an array
(def colors ["red" "green"])
(def extended-colors (conj colors "blue"))


;; --------------------------
;; Do
;; --------------------------
;; Clojure "do" is a special form that evaluates each contained expression
;in order and only returns the value of the last.
(do "foo" "bar")

;; Functions
;; You can have multiple statements in a function.
(fn [name]
 (println "Hey" name)
 (str "Hello " name))

;; Also, you can use the "do" to implicitly declare the function bodies.
;; The next function is equivalent to the one above.
(fn [name]
 (do ;; This "do" is redundant, you can remove it.
   (println "Hey" name)
   (str "Hello " name)))


;; --------------------------
;; Bindings (let)
;; --------------------------
(defn hello-b
 "Say hello, but create some bindings before"
 [name]
 (let [greeting "Hello" sep " " emoji "👋"]
   (str greeting sep name sep emoji)))

(hello-b "joe")


;; --------------------------
;; Multi-arity Functions
;; --------------------------
;; aka Method Overload
(defn hello
 "Overloaded Hello, you can call me in both ways."
 ([name]
  (str "Hello " name " 🎉"))
 ([first-name last-name]
  (hello (str first-name " " last-name)))
 )

(hello "joe")
(hello "joe" "buddy")


;; --------------------------
;; Varargs
;; --------------------------
;; https://clojuredocs.org/clojure.core/cons
;; https://clojuredocs.org/clojure.core/conj
(defn hello-args
 "A nice example of varargs"
 [& names]
 (clojure.string/join " " (cons "Hello" names)))

(hello-args "joe" "the" "buddy")

;; You can also destruct the varargs (example 1)
(defn hello-args-v2
 "A varargs example with destructed parameters"
 [first-name & more-names]
 (clojure.string/join " " (conj more-names (clojure.string/upper-case first-name) "Hello")))

(hello-args-v2 "joe" "the" "buddy")

;; Example 2
;; The difference for the previous example is that now we have a single varargs
;; parameter (names). Before, we had a first parameter and then a varargs.
(defn hello-args-v3
 "A varargs example with destructed parameters"
 [& [first-name & more-names :as names]]
 (println "Received" (count names) "arguments, where" (count more-names) "are the surname(s).")
 (clojure.string/join " " (conj more-names (clojure.string/upper-case first-name) "Hello")))

(hello-args-v3 "joe" "the" "buddy")
