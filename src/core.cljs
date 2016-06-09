(ns moria.core
  (:require cljsjs.mithril
            [moria.utils :refer [valid-component?]]))

(enable-console-print!)

(defn m
  [& args]
  (apply js/m (clj->js args)))

(defn component
  ([c]
   (component c {}))
  ([c attrs & args]
   {:pre [(valid-component? c)]}
   ; breaking change args are applied in Mithril
   ; m.component(component, attrs, a1, a2, a3 ... aN)
   ; in here the view / controller fn in component needs to account for
   ; this
   (.component js/m (clj->js c) (clj->js attrs) (clj->js args))))

(defn prop
  ([]
   (prop nil))
  ([val]
   (.prop js/m val)))

(defn withAttr
  [property f]
  (.withAttr js/m property f))

(defn mount
  [elm c]
  (.mount js/m elm c))

(defn route
  ([]
   (.route js/m))
  ([element root routes]
   (.route js/m element root (clj->js routes))))

; breaking change in Mithril this would be m.route
; here the route fn is already overloaded enough!
(def route-config (.-route js/m))

; breaking change in Mithril this would be m.route
; the the route fn is already overloaded enough!
(defn route-to
  ([path]
   {:pre [(string? path)]}
   (.route js/m path))
  ([path params]
   {:pre [(string? path)]}
   (.route js/m path params))
  ([path params replace-history]
   {:pre [(string? path)]}
   (.route js/m path params replace-history)))

; breaking
(defn route-mode
  [mode]
  (set! (.. js/m -route -mode) mode))

; breaking
(defn route-param
  ([]
   (.param js/m.route))
  ([k]
   (.param js/m.route k)))

; breaking
(defn build-query-string
  [data]
  (.buildQueryString js/m.route (clj->js data)))

; breaking
(defn parse-query-string
  [s]
  (js->clj (.parseQueryString js/m.route s)))

; TODO: this is gonna be a big one
(defn request
  [req]
  (.request js/m (clj->js req)))

(defn deferred
  [])

(defn sync
  [])

(defn trust
  [])

(defn render
  [])

(defn redraw
  [])

(defn redraw-strategy
  [])

(defn start-computation
  [])

(defn end-computation
  [])

(defn deps
  [])
