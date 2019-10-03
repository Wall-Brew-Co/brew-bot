(defproject brew-bot "1.0.0-alpha"
            :description "A quick, dirty way to get randomized beer recipes"
            :url "https://github.com/nnichols/brew-bot"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[antizer "0.3.1"]
                           [cider/piggieback "0.3.8"]
                           [cljsjs/react "15.6.2-4"]
                           [cljsjs/react-dom "15.6.2-4"]
                           [cljx-sampling "0.1.0"]
                           [day8.re-frame/http-fx "0.1.6"]
                           [day8.re-frame/test "0.1.5"]
                           [figwheel-sidecar "0.5.14"]
                           [org.clojure/clojure "1.10.1"]
                           [org.clojure/clojurescript "1.10.520" :scope "provided"]
                           [re-frame "0.10.5"]
                           [reagent "0.7.0"]
                           [reagent-utils "0.3.1"]]

            :plugins [[com.jakemccrary/lein-test-refresh "0.19.0"]
                      [lein-cljsbuild "1.1.7"]
                      [lein-doo "0.1.8"]
                      [lein-figwheel "0.5.14"]]

            :aliases {"prod-build" ["do" "clean" ["cljsbuild" "once" "prod"]]
                      "dev-build"  ["do" "clean" ["cljsbuild" "once" "dev"] "figwheel"]
                      "test-build" ["do" "clean" ["cljsbuild" "once" "dev"] ["doo" "once"]]}

            :min-lein-version "2.5.3"
            :main ^:skip-aot brew-bot.main
            :target-path "target/%s"
            :clean-targets ^{:protect false} ["resources/public/js/compiled" "resources/test" "target"]

            :figwheel {:http-server-root "public"
                       :nrepl-port 7002
                       :css-dirs ["resources/public/css"]
                       :nrepl-middleware [cider.piggieback/wrap-cljs-repl]}

            :doo {:build "test"
                  :alias {:default [:phantom]}}

            :cljsbuild {:builds [{:id "prod"
                                  :source-paths ["src/cljs"]
                                  :compiler {:main brew-bot.main
                                             :output-to "resources/public/js/compiled/app.js"
                                             :optimizations :advanced
                                             :pretty-print false
                                             :parallel-build true}}

                                 {:id "dev"
                                  :source-paths ["src/cljs"]
                                  :figwheel {:on-jsload "brew_bot.main/init"}
                                  :compiler {:main "brew-bot.main"
                                             :asset-path "js/compiled/out"
                                             :output-to "resources/public/js/compiled/app.js"
                                             :output-dir "resources/public/js/compiled/out"
                                             :source-map true
                                             :optimizations :none
                                             :parallel-build true
                                             :pretty-print true}}

                                 {:id "test"
                                  :source-paths ["src/cljs" "test/cljs"]
                                  :compiler {:main "brew-bot.runner"
                                             :output-to "resources/test/app.js"
                                             :output-dir "resources/test/js/compiled/out"
                                             :optimizations :none
                                             :parallel-build true}}]})
