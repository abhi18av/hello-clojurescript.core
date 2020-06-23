(defproject hello-clojurescript.core "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"

  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"]
                 [com.wsscode/pathom "2.2.31"]
                 [cljs-http "0.1.46"]
                 [org.clojure/core.async "1.2.603"]
                 [appliedscience/js-interop "0.2.4"]]

  :source-paths ["src"]

  :aliases {"fig"         ["run" "-m" "figwheel.main"]
            "fig:dev"     ["run" "-m" "figwheel.main" "-b" "dev" "-r"]
            "fig:browser" ["run" "-m" "figwheel.main" "-b" "browser" "-r"]
            "fig:min"     ["run" "-m" "figwheel.main" "-O" "advanced" "-bo" "dev"]
            "fig:test"    ["run" "-m" "figwheel.main" "-co" "test.cljs.edn" "-m" hello-clojurescript.test-runner]}

  :profiles {:dev {:dependencies [[com.bhauman/figwheel-main "0.2.9"]]}})

