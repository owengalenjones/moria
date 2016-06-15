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

; TODO: this should be channels
(defn request
  ([req]
   (.request js/m (clj->js req)))
  ([req callback]
   {:pre [(fn? callback)]}
   (.then (.request js/m (clj->js req)) callback))
  ([req callback error]
   {:pre [(fn? callback)
          (fn? error)]}
   (.then (.request js/m (clj->js req)) callback error)))

(defn request-sync
  [req error]
  (let [response (atom nil)]
    (-> (.request js/m (clj->js req))
        (.then #(reset! response %)
               error))
    response))

(defn deferred [] (.deferred js/m))
(defn resolve [d v] (.resolve d v))
(defn promise [d] (.-promise d))
(defn then [p f] (.then p f))
