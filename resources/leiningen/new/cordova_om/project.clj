(defproject {{name}} "0.1.0-SNAPSHOT"
            :description "FIXME: write this!"
            :url "http://example.com/FIXME"

            :dependencies [[org.clojure/clojure "1.7.0-beta1"]
                           [org.clojure/clojurescript "0.0-3196"]
                           [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                           [org.omcljs/om "0.8.8"]
                           [sablono "0.3.4"]]

            :node-dependencies [[source-map-support "0.2.8"]]

            :plugins [[lein-cljsbuild "1.0.4"]
                      [lein-npm "0.4.0"]]

            :source-paths ["src" "target/classes"]

            :clean-targets ["out" "out-adv" "cordova-proj/www/js"]

            :cljsbuild {
                        :builds [{;; index_dev.html
                                  :id "web-dev"
                                  :source-paths ["src"]
                                  :compiler {
                                             :main {{name}}.core
                                                   :output-to "out/{{name}}.js"
                                                   :output-dir "out"
                                                   :optimizations :none
                                                   :cache-analysis true
                                                   :source-map true}}

                                 {;; index_release.html
                                  :id "web-release"
                                  :source-paths ["src"]
                                  :compiler {
                                             :main {{name}}.core
                                                   :output-to "out-adv/{{name}}.min.js"
                                                   :output-dir "out-adv"
                                                   :optimizations :advanced
                                                   :pretty-print false}}

                                 {;; copy index.html to cordova-proj/www
                                  :id "phone-dev"
                                  :source-paths ["src"]
                                  :compiler {:main {{name}}.core
                                                   :asset-path "js"
                                                   :output-to "cordova-proj/www/js/index.js"
                                                   :output-dir "cordova-proj/www/js"
                                                   :optimizations :none
                                                   :cache-analysis true
                                                   :source-map true}}]})
