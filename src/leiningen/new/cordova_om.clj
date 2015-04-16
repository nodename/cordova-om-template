(ns leiningen.new.cordova-om
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "cordova-om"))

(defn cordova-om
  [name]
  (let [data {:name name
              :capitalized (clojure.string/capitalize name)
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh cordova-om project.")
    (->files data
             ["project.clj" (render "project.clj" data)]
             ["README.md" (render "README.md" data)]
             ["index.html" (render "index.html" data)]
             ["index_dev.html" (render "index_dev.html" data)]
             ["index_release.html" (render "index_release.html" data)]
             ["LICENSE" (render "LICENSE" data)]
             ["src/{{name}}/core.cljs" (render "core.cljs" data)]
             [".gitignore" (render "gitignore" data)])))
