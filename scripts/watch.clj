(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'moria.core
   :output-to "out/moria.js"
   :output-dir "out"})
