(defproject moria "0.1.0"
  :description "CLJS Wrapper for Mithril.js"
  :url "https://github.com/owengalenjones/moria"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [cljsjs/mithril "0.2.4-0"]]
  :jvm-opts ^:replace ["-Xmx1g" "-server"]
  :plugins [[lein-npm "0.6.1"]]
  :source-paths ["src" "target/classes"]
  :clean-targets ["out" "release"]
  :target-path "target")
