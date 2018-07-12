(ns moria.core
  (:require cljsjs.mithril
            [moria.utils :refer [valid-component?]]
            [clojure.string :as string]))

(enable-console-print!)

(defn m
  ([selector]
   (js/m (name selector)))
  ([selector attr]
   (js/m (name selector) (clj->js attr)))
  ([selector attr & children]
   (js/m (name selector) (clj->js attr) (clj->js children))))

(defn render
  [element vnodes]
  (.render js/m element vnodes))

(defn mount
  [element component]
  (.mount js/m element component))

(defn route
  [element root routes]
  (.route js/m element root (clj->js routes)))

(def http-methods
  #{"GET"
    "POST"
    "PUT"
    "PATCH"
    "DELETE"
    "HEAD"
    "OPTIONS"})

(defn request
  ([url]
   (request url {:method "GET"}))
  ([url {:keys [method] :as options}]
   (when (not (contains? http-methods method))
     (throw (js/Error. (str method " not in (" (string/join ", " http-methods) ")"))))
   (.request js/m url (clj->js options))))

(defn jsonp
  ([url]
   (jsonp url {}))
  ([url options]
   (.jsonp js/m url (clj->js options))) )

(defn with-attr
  ([attr-name callback]
   (.withAttr js/m attr-name callback))
  ([attr-name callback this-arg]
   (.withAttr js/m attr-name callback this-arg)))

(defn trust
  [html]
  (.trust js/m html))

(defn fragment
  [attrs children]
  (.fragment js/m (clj->js attrs) (clj->js children)))

(defn redraw
  []
  (.redraw js/m))

(def version (.-version js/m))

(defn promise
  [f]
  (js/Promise. f))
