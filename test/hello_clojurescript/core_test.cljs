(ns hello-clojurescript.core-test
    (:require
     [cljs.test :refer-macros [deftest is testing]]
     [hello-clojurescript.core :refer [multiply]]))

(deftest multiply-test
  (is (= (* 1 2) (multiply 1 2))))

