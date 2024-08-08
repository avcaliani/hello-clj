;; --------------------------
;; QUICK START
;; --------------------------
;; The following code was created to be executed locally in a REPL.
;; Option 1: Online at "https://tryclojure.org"
;; Option 2: Local, on your terminal execute "clj"

;; -----------------------------------
;; Modeling Entities & Relationships
;; -----------------------------------
;; In this example we are going to use a very simple bank account data model.
;; In Clojure we don't build classes, we craete stand-alone functions that 
;; serve the same purpose.

;; A customer
{:customer-id "#001" :first-name "Joe" :last-name "Buddy"}

;; An account
{:account-id "#001-01" :account-type :checking}

;; Currency
(def currencies {
  :usd {:divisor 100 :code "USD" :sign "$" :desc "US Dollars 🇺🇸"}
  :brl {:divisor 100 :code "BRL" :sign "R$" :desc "Brazilian Real 🇧🇷"}
  :ukg {:divisor (* 17 29) :code "UKG" :sign "ʛ" :desc "Galleons from UK 🇬🇧"}})

(def default-currency (:brl currencies))

;; Creating a "constructor" to the "Money" entity. 
(defn make-money
  "Takes an account and currecnty, creating a Money entity."
  ([] (make-money 0))
  ([amount] (make-money amount default-currency))
  ([amount currency] {:amount amount :currency currency}))

;; Money ($12.00 USD)
;; TBD

;; A transaction
{ :transation-type :debit
  :details {,,,}
  :account-id "#001-01"
  :timestamp 1723114136634
  :amount {:amount 1200 :currency :usd }} ; This is the Money entity
