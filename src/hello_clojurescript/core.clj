(ns hello-clojurescript.core
 (:require
    [com.wsscode.pathom.core :as p]
    [com.wsscode.pathom.connect :as pc]
    [clojure.core.async :refer [<!!]]))



;;;;;;;;;;;;;;;;;;

;; How to go from :person/id to that person's details
(pc/defresolver person-resolver [env {:keys [person/id] :as params}]
  ;; The minimum data we must already know in order to resolve the outputs
  {::pc/input  #{:person/id}
   ;; A query template for what this resolver outputs
   ::pc/output [:person/name {:person/address [:address/id]}]}
  ;; normally you'd pull the person from the db, and satisfy the listed
  ;; outputs. For demo, we just always return the same person details.
  {:person/name "Tom"
   :person/address {:address/id 1}})

;; how to go from :address/id to address details.
(pc/defresolver address-resolver [env {:keys [address/id] :as params}]
  {::pc/input  #{:address/id}
   ::pc/output [:address/city :address/state]}
  {:address/city "Salem"
   :address/state "MA"})

;; define a list with our resolvers
(def my-resolvers [person-resolver address-resolver])

;; setup for a given connect system
(def parser
  (p/parallel-parser
    {::p/env     {::p/reader               [p/map-reader
                                            pc/parallel-reader
                                            pc/open-ident-reader
                                            p/env-placeholder-reader]
                  ::p/placeholder-prefixes #{">"}}
     ::p/mutate  pc/mutate-async
     ::p/plugins [(pc/connect-plugin {::pc/register my-resolvers})
                  p/error-handler-plugin
                  p/trace-plugin]}))

;; A join on a lookup ref (Fulcro ident) supplies the starting state of :person/id 1.
;; env can have anything you want in it (e.g. a Datomic/SQL connection, network service endpoint, etc.)
;; the concurrency is handled though core.async, so you have to read the channel to get the output
(<!! (parser {} [{[:person/id 1] [:person/name {:person/address [:address/city]}]}]))
; => {[:person/id 1] {:person/name "Tom" :person/address {:address/city "Salem"}}}

;;;;;;;;;;;;;;;;;;;;;;;

(pc/defresolver answer [_ _]
  {::pc/output [:answer-to-everything]}
  {:answer-to-everything 42})

(pc/defresolver answer-plus-one [_ {:keys [answer-to-everything]}]
  {::pc/input  #{:answer-to-everything}
   ::pc/output [:answer-plus-one]}
  {:answer-plus-one (inc answer-to-everything)})

(def parser
  (p/parallel-parser
   {::p/env     {::p/reader [p/map-reader
                             pc/parallel-reader
                             pc/open-ident-reader
                             p/env-placeholder-reader]
                 ::p/placeholder-prefixes #{">"}}
    ::p/mutate  pc/mutate-async
    ::p/plugins [(pc/connect-plugin {::pc/register [answer answer-plus-one]})
                 p/error-handler-plugin
                 p/trace-plugin]}))



(<!! (parser {} [:answer-to-everything :answer-plus-one]))

;;;;;;;;;;


(defn read-value [{:keys [ast]}]
  (let [key (get ast :dispatch-key)]
    (case key
      :name "Saul"
      :family "Goodman"
;; good pratice: return ::p/continue when your reader is unable
;; to handle the request
      ::p/continue)))

(def parser (p/parser {::p/plugins [(p/env-plugin {::p/reader read-value})]}))

(parser {} [:name :family])
;; => {:name "Saul" :family "Goodman"}
