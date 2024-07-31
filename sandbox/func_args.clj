;; The following code was created to be executed locally in a REPL.
;; Option 1: Online at "https://tryclojure.org"
;; Option 2: Local, on your terminal execute "clj"

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

;; --------------------------
;; Maps (aka Dict)
;; --------------------------
;; https://clojuredocs.org/clojure.core/remove
(defn hello-map-v1
  "An example receiving a Map (aka Dict 🐍)"
  [person]
  (let [person-names 
        (remove nil? ["Hello" (:first-name person) (:middle-name person) (:last-name person)])]
    (clojure.string/join " " person-names)))


(defn hello-map-v2
  "An example receiving a Map (aka Dict 🐍).
   In this version destructing the args."
  [{first-name :first-name middle-name :middle-name last-name :last-name}]
  (let [person-names (remove nil? ["Hello" first-name middle-name last-name])]
    (clojure.string/join " " person-names)))


(defn hello-map-v3
  "An example receiving a Map (aka Dict 🐍).
   In this version we are destructing the args using the :keys keyword! 
   It's gonna simplify the declaration and assume the map keys will be 
   the same as the variables."
  [{:keys [first-name middle-name last-name]}]
  (let [person-names (remove nil? ["Hello" first-name middle-name last-name])]
    (clojure.string/join " " person-names)))


(defn hello-map-v4
  "An example receiving a Map (aka Dict 🐍).
   In this version we are gonna asign default values for missing values."
  [person-names]
  (let [defaults {:middle-name "N/A"}
        merged-info (merge defaults person-names)
        names ["Hello" (:first-name merged-info) (:middle-name merged-info) (:last-name merged-info)]] 
    (clojure.string/join " " names)))


(defn hello-map-v5
  "An example receiving a Map (aka Dict 🐍).
   In this version we are gonna asign default values for missing values, 
   but using the :or keyword."
  [{:keys [first-name middle-name last-name] :or {middle-name "N/A"}}]
  (let [names ["Hello" first-name middle-name last-name]]
    (clojure.string/join " " names)))


(defn hello-map
  "An example receiving a Map (aka Dict 🐍).
   The final version will destruct the map but also give an alias to it."
  [{:keys [first-name middle-name last-name] :as person}]
  (println "Person map with" (count person) "keys!" (keys person))
  (let [names (remove nil? ["Hello" first-name middle-name last-name])]
    (clojure.string/join " " names))
  )


(hello-map {:first-name "Joe" :middle-name "the" :last-name "Buddy" :employee-id "#001"})
(hello-map {:first-name "Joe" :last-name "Buddy" :employee-id "#001"})
