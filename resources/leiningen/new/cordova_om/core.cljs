(ns {{name}}.core
  (:require-macros
    [cljs.core.async.macros :refer [go]])
  (:require
    [cljs.core.async :refer [<! timeout]]
    [om.core :as om :include-macros true]
    [sablono.core :as html :refer-macros [html]]
    [clojure.browser.repl :as repl]))

;; (repl/connect "http://localhost:9000/repl")

;; Thanks to Keith Irwin for working initialization code https://gist.github.com/zentrope/bf359cec33f6fcc02be4

(enable-console-print!)

(defonce app
         (atom {:msg "Hello"
                :connected false}))

(defn browser-mode!
      []
      (go (<! (timeout 500))
          (.dispatchEvent js/document (js/CustomEvent. "deviceready"))))

(defn- root-frame
       [app owner opts]
       (reify
         om/IDidMount
         (did-mount [_]
                    (.addEventListener js/document "deviceready" #(om/update! app :connected true))
                    (browser-mode!))

         om/IRenderState
         (render-state [_ _]
                       (html
                         [:div.app
                          [:h1 "Apache Cordova"]
                          [:div#deviceready.blink
                           (if (:connected app)
                             [:p.event.received {:style {:display "block"}} "{{name}} is Ready!"]
                             [:p.event.listening "Connecting to Device..."])]]))))

(defn- bootstrap!
       []
       (let [options {:target js/document.body}]
            (om/root root-frame app options)))

(set! (.-onload js/window) bootstrap!)
