(ns ^:figwheel-hooks hello-clojurescript.core
  (:require
   [goog.dom :as gdom]))

;;;;;;;;;;;;;;;;;
;; UTILS
;;;;;;;;;;;;;;;;;

(enable-console-print!)

;;;;;;;;;;;;;;;;;
;; PLAYGROUND
;;;;;;;;;;;;;;;;;


;;(js/console.log "console.log")
;; (js/console.clear)


(println (type 1))
(println (type 1.0))

(println {:a "A" :c {:b "b"}})


(def js-arr (array 1 2 3))





















;;;;;;;;;;;;;;;;;
;; TESTING
;;;;;;;;;;;;;;;;;

;; This function is used in test
(defn multiply [a b] (* a b))

;;;;;;;;;;;;;;;;;
;; APP STATE
;;;;;;;;;;;;;;;;;


;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
(gdom/getElement "app"))


;;;;;;;;;;;;;;;;;
;; RELOAD HOOKS
;;;;;;;;;;;;;;;;;

;; (defn ^:before-load my-before-reload-callback []
;;   (println "BEFORE reload!!!"))

;; (defn ^:after-load my-after-reload-callback []
;;   (println "AFTER reload!!!"))

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
(println "REPL reloaded!")
;; optionally touch your app-state to force rerendering depending on
;; your application
(swap! app-state update-in [:__figwheel_counter] inc))
