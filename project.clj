(defproject brew-bot "0.0.0"
  :description "A quick, dirty way to get randomized beer recipes"
  :url "https://github.com/nnichols/brew-bot"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cljsjs/react "15.6.2-4"]
                 [cljsjs/react-dom "15.6.2-4"]
                 [org.clojure/clojure "1.10.1"]
                 [cljx-sampling "0.1.0"]
                 [org.clojure/clojurescript "1.10.520" :scope "provided"]
                 [re-frame "0.10.5"]
                 [reagent "0.7.0"]
                 [reagent-utils "0.3.1"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.19" :exclusions [cider/cider-nrepl]]]

  :min-lein-version "2.5.3"
  :bikeshed {:long-lines false}
  :eastwood {:add-linters [:unused-fn-args :unused-private-vars]}
  :main ^:skip-aot brew-bot.main
  :target-path "target/%s"
  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target" "test/js"]
  :profiles {:uberjar {:aot :all}}
  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]

                        :figwheel {:on-jsload "brew-bot.main/mount-root"}

                        :compiler {:main brew-bot.main
                                   :output-to "resources/public/js/compiled/app.js"
                                   :output-dir "resources/public/js/compiled/out"
                                   :asset-path "js/compiled/out"
                                   :source-map-timestamp true
                                   :optimizations :whitespace
                                   :parallel-build true}}

                       {:id "min"
                        :source-paths ["src/cljs"]
                        :compiler {:main brew-bot.main
                                   :output-to "resources/public/js/compiled/app.js"
                                   :optimizations :advanced
                                   :pretty-print false
                                   :parallel-build true}}]}
 :figwheel {:css-dirs ["resources/public/css"]
            :nrepl-port 7888})
