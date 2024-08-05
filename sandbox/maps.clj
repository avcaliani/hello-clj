;; --------------------------
;; QUICK START
;; --------------------------
;; The following code was created to be executed locally in a REPL.
;; Option 1: Online at "https://tryclojure.org"
;; Option 2: Local, on your terminal execute "clj"

(defn run-payroll
  "Run the payroll for an employee."
  [employee-id]
  (println "Payroll for employee " employee-id "triggered ✅"))


;; --------------------------
;; Maps
;; --------------------------
;; Maps in Clojure aka Dicts in Python 🐍
{:first 1 :second 2} ;; or (array-map :first 1 :second 2)
(type (array-map :first 1 :second 2)) ;; clojure.lang.PersistentArrayMap


;; You can use string as key, but it's not recommended.
(def joe { :first-name "Joe"
           :last-name "Buddy"
           :business-unit :it-eng
           :employee-id "#001" 
           :meta { :picture-id "d829f2f4.png" }})

(get joe :employee-id) ;; or (:employee-id joe)
(-> joe (:meta) (:picture-id))

;; In Clojure, the -> symbol represents the thread-first macro, 
;; also known as the threading macro. It is used to improve the readability 
;; of nested function calls by "threading" an initial value through a series 
;; of functions.
(-> joe (:employee-id) (run-payroll)) ;; Same => (run-payroll (:employee-id joe))


;; --------------------------
;; Records
;; --------------------------
;; Records in Clojure aka Data Classes in Python 🐍
;; Side note:
;;   Versions of Clojure prior to 1.6 favored `defstruct` since
;;   records were in a pre-release form, so you should be using records from
;;   version 1.6 on.
;; Side note:
;;    Maps x Records
;;      - Maps are simpler ✅
;;      - A Record can do everything a Map can do, but the inverse is not always true.
(defrecord Employee [ first-name
                      last-name
                      business-unit
                      employee-id ])

(def joe-e (->Employee "Joe" "Buddy" :it-eng "#001"))

(def nina-e (map->Employee { :first-name "Nina" 
                             :last-name "Buddy" 
                             :business-unit :it-eng 
                             :employee-id "#001" }))
