(ns ^:figwheel-hooks hello-clojurescript.core
  (:require
   [goog.dom :as gdom]))


;;;;;;;;;;;;;;;;;
;; REFERENCES
;;;;;;;;;;;;;;;;;

;; https://cljs.github.io/api/

;; https://www.freecodecamp.org/news/here-is-a-quick-overview-of-the-similarities-and-differences-between-clojurescript-and-javascript-c5bd51c5c007/

;; https://www.verypossible.com/blog/clojurescript-and-javascript-interoperability-a-comprehensive-guide

;; https://clojurescript.org/guides/faq-js


;; https://cljs.info/cheatsheet/


;; https://kanaka.github.io/clojurescript/web/synonym.html

;;;;;;;;;;;;;;;;;
;; UTILS
;;;;;;;;;;;;;;;;;


(enable-console-print!)

;;;;;;;;;;;;;;;;;
;; PLAYGROUND
;;;;;;;;;;;;;;;;;


;; (js/alert "Hello, ClojureScript!")


;; (js/console.clear)


;; (println (type 1))
;; (println (type 1.0))

;; (println {:a "A" :c {:b "b"}})


;; ;;;;;;;;;;;;;;;;;
;; ;; ARRAY
;; ;; https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array
;; ;;;;;;;;;;;;;;;;;




;;(comment


;; var fruits = ['Apple', 'Banana'];

;; console.log(fruits.length);


;; var first = fruits[0];
;; // Apple

;; var last = fruits[fruits.length - 1];


;; fruits.forEach(function(item, index, array) {
;;                                              console.log(item, index);
;;                                              });

;; var newLength = fruits.push('Orange');

;; var last = fruits.pop();


;; var first = fruits.shift();


;; var newLength = fruits.unshift('Strawberry')


;; fruits.push('Mango');


;; var pos = fruits.indexOf('Banana');


;; var removedItem = fruits.splice(pos, 1)

;; var vegetables = ['Cabbage', 'Turnip', 'Radish', 'Carrot'];
;; console.log(vegetables);
;; // ["Cabbage", "Turnip", "Radish", "Carrot"]

;; var pos = 1, n = 2;

;; var removedItems = vegetables.splice(pos, n);
;; // this is how to remove items, n defines the number of items to be removed,
;; // from that position(pos) onward to the end of array.

;; console.log(vegetables);
;; // ["Cabbage", "Carrot"] (the original array is changed)

;; console.log(removedItems);
;; // ["Turnip", "Radish"]


;; var shallowCopy = fruits.slice();



;;)







;; (js/console.clear)

;; (def fruits (array "Apple" "Banana"))

;; (get fruits 1)

;; ;;;;;;;;;;;;
;; (count fruits)

;; ;;;;;;;;;;;;
;; (map println fruits)


;; (comment
;;   (for [i (range 10)]
;;     (println i))

;;   (nth fruits 4))


;; (for [pos (range (count fruits))]
;;   (println (nth fruits pos) pos))

;; ;;;;;;;;;;;;
;; ;; DONE how to call a javascript function push on this clojurescript array


;; (.push fruits "Orange")


;; ;;;;;;;;;;;;

;; (.pop fruits)


;; ;;;;;;;;;;;;;;;;;
;; ;; VECTOR - ClojureScript counterpart for JS-Array
;; ;;;;;;;;;;;;;;;;;


;; (def fruits-v ["Apple" "Banana"])

;; (def fruits-v-js (clj->js fruits-v))


;; (count fruits-v)

;; (nth fruits-v 0)

;; (nth fruits-v (- (count fruits-v) 1))

;; (last fruits-v)



;; (for [pos (range (count fruits-v))]
;;   (println (nth fruits-v pos) pos))


;; (conj fruits-v "Orange")

;; (drop 1 fruits-v )

;; (rest fruits-v )

;; (cons "Strawberry" fruits-v)

;; (.indexOf fruits-v "Banana")


;; (comment
;;   (let [coll [0 1 2 3 4 5]
;;         i 3]
;;     (concat (subvec coll 0 i)
;;             (subvec coll (inc i))))

;;   (drop-elem [0 1 2 3 4 5] 3))



;; (defn drop-elem [collectn index]
;;   (let [coll collectn
;;         i index]
;;     (concat (subvec coll 0 i)
;;             (subvec coll (inc i)))))




;;;;;;;;;;;;;;;;;
;; OBJECT
;; https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Object
;;;;;;;;;;;;;;;;;














;;;;;;;;;;;;;;;;;
;; HASH-MAP - CLOJURE
;;;;;;;;;;;;;;;;;













































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
(println "<<<<< REPL RELOADED >>>>>")
;; optionally touch your app-state to force rerendering depending on
;; your application
(swap! app-state update-in [:__figwheel_counter] inc))
