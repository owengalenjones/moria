(ns moria.utils
  (:require cljsjs.mithril))

(defn valid-component?
  "Checks a component object for a mandatory :view key.
  For nicer error messages."
  [c]
  (if (contains? c :view)
    true
    (do
      (throw (js/Error. (str "component with no :view" c)))
      false)))
