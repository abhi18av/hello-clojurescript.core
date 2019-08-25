(ns ^:figwheel-hooks hello-clojurescript.core
  (:require
   [goog.dom :as gdom]
   [goog.object :as gobj]))


;;;;;;;;;;;;;;;;;
;; REFERENCES
;;;;;;;;;;;;;;;;;

;; http://localhost:9500/
;; http://localhost:9500/figwheel-extra-main/auto-testing ;; testing figwheel

;; https://cljs.github.io/api/

;; https://www.freecodecamp.org/news/here-is-a-quick-overview-of-the-similarities-and-differences-between-clojurescript-and-javascript-c5bd51c5c007/

;; https://www.verypossible.com/blog/clojurescript-and-javascript-interoperability-a-comprehensive-guide

;; https://clojurescript.org/guides/faq-js

;; https://www.spacjer.com/blog/2014/09/12/clojurescript-javascript-interop/

;; https://cljs.info/cheatsheet/

;; https://google.github.io/closure-library/api/
;; https://m.seehuhn.de/data/jvjsdoc/example/index.html

;; https://kanaka.github.io/clojurescript/web/synonym.html

;; https://www.rubberducking.com/2018/04/overview-of-clojurescript-110-features.html

;; TODO https://codetower.github.io/es6-features/

;;;;;;;;;;;;;;;;;
;; UTILS
;;;;;;;;;;;;;;;;;


(enable-console-print!)

(js/console.clear)



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




;; (def js-object {"a" "A"})

;; (type js-object)

;; (def js-object2 (js-obj "a" "A" "b" "B"))

;; (type js-object2)



;; TODO add key-val to javascript object using clojurescript

;; (conj js-object2 "c"  "C")

;; (cons js-object2 #js "c" "C")

;; (assoc js-object2 "c" "C")


;; (gobj/set js-object2 "c" "C")


;; (gobj/get js-object2 "c")

;; (js/delete js-object2 "c")


;; (js/Object.values js-object2)

;; (gobj/getValues js-object2)


;; (gobj/remove js-object2 "c")

;; (js-delete js-object2 "c")

;;;;;;; js-maps


;; (def es6-map (js/Map.))
;; (.set es6-map "a" "A")
;; (.set es6-map "b" "B")
;; (.get es6-map "a")
;; (.-size es6-map)


;; ;;; WeakMap

;; (def wm (js/WeakMap.))
;; (def o #js{:a 10})
;; (.set wm o 100)
;; (.get wm o)
;; ;;=> 100

;; (js/Number.isNaN ##NaN)
;; ;;=> true

;; (let [obj #js{:a 1}]
;;   (js/Object.defineProperty obj "b" #js{:value 2})
;;   (set! (.-c obj) 3)
;;   (js/Reflect.ownKeys obj))
;; ;;=> #js ["a" "b" "c"]

;; (let [target #js{:foo "Welcome, Foo"}
;;       proxy (js/Proxy. target
;;                        #js{:get
;;                            (fn get [receiver name]
;;                              (str "Hello " name))})]
;;   (.-foo proxy))
;; ;;=> "Hello foo"


;; ;;;;;;;;;;;;;;;;;
;; ;; HASH-MAP - CLOJURE
;; ;;;;;;;;;;;;;;;;;


;; (def cljs-hashmap {:a "A" :b "B"})

;; (def js-cljs-hashmap (clj->js cljs-hashmap))

;; (conj cljs-hashmap {:c "C"})

;; ;; (disj cljs-hashmap [:c])


;; (dissoc cljs-hashmap :b)

;; (keys cljs-hashmap)

;; (vals cljs-hashmap)

;; (get cljs-hashmap :c 0)


;;;;;;;;;;;;;;;;;
;; INTERVIEWCAKE
;; 00 => Algorithmic Thinking
;;;;;;;;;;;;;;;;;


;; 01 - Big O Notation





;; 02 - Data Structures
;; 03 - Logarithms







































;;;;;;;;;;;;;;;;;
;; LEETCODE
;; https://github.com/kaeducation/LeetCode_JS/tree/master/exercises
;;;;;;;;;;;;;;;;;

;; LC3 - Longest substring without repeating characters































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
