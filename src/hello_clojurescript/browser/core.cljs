(ns ^:figwheel-hooks hello-clojurescript.browser.core
  (:require
   [goog.dom :as gdom]
   [clojure.set]
   [goog.object :as gobj]))


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
  (println "<<<<< REPL RELOADED >>>>>")
;; optionally touch your app-state to force rerendering depending on
;; your application
  (swap! app-state update-in [:__figwheel_counter] inc))
