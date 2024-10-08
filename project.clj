(defproject com.wallbrew/brew-bot "3.3.0"
  :description "A library to generate randomized beer recipes."
  :url "https://github.com/Wall-Brew-Co/brew-bot"
  :license {:name         "MIT"
            :url          "https://opensource.org/licenses/MIT"
            :distribution :repo
            :comments     "Same-as all Wall-Brew projects"}
  :scm {:name "git"
        :url  "https://github.com/Wall-Brew-Co/brew-bot"}
  :pom-addition [:organization
                 [:name "Wall Brew Co."]
                 [:url "https://wallbrew.com"]]
  :dependencies [[cljx-sampling "0.1.0"]
                 [com.wallbrew/brewtility "2.2.1"]
                 [com.wallbrew/common-beer-data "1.2.0"]
                 [com.wallbrew/common-beer-format "2.1.0"]
                 [nnichols "1.1.0"]
                 [org.clojure/clojure "1.12.0"]
                 [org.clojure/clojurescript "1.11.132" :scope "provided"]]

  :plugins [[com.github.clj-kondo/lein-clj-kondo "2024.09.27"]
            [com.wallbrew/lein-sealog "1.7.0"]
            [com.wallbrew/bouncer "1.0.0"]
            [lein-cljsbuild/lein-cljsbuild "1.1.8"]
            [mvxcvi/cljstyle "0.16.630"]
            [ns-sort/ns-sort "1.0.3"]]

  :deploy-repositories [["clojars" {:url           "https://clojars.org/repo"
                                    :username      :env/clojars_user
                                    :password      :env/clojars_pass
                                    :sign-releases false}]]
  :deploy-branches ["master"]

  :aliases {"test-build" ["do" "clean" ["cljsbuild" "once" "test"] ["doo" "once"] ["test"]]}

  :profiles {:uberjar {:aot :all}
             :dev     {:dependencies [[doo "0.1.11"]]
                       :plugins      [[lein-doo "0.1.11"]]}}

  :min-lein-version "2.5.3"

  :cljsbuild {:builds [{:id           "test"
                        :source-paths ["src" "test"]
                        :compiler     {:main           "brew-bot.runner"
                                       :output-to      "target/test/app.js"
                                       :output-dir     "target/test/js/compiled/out"
                                       :optimizations  :none
                                       :parallel-build true}}]}

  :doo {:build "test"
        :alias {:default [:chrome-headless-no-sandbox]}
        :paths {:karma "./node_modules/karma/bin/karma"}
        :karma {:launchers {:chrome-headless-no-sandbox {:plugin "karma-chrome-launcher"
                                                         :name   "ChromeHeadlessNoSandbox"}}
                :config    {"captureTimeout"             210000
                            "browserDisconnectTolerance" 3
                            "browserDisconnectTimeout"   210000
                            "browserNoActivityTimeout"   210000
                            "customLaunchers"            {"ChromeHeadlessNoSandbox" {"base"  "ChromeHeadless"
                                                                                     "flags" ["--no-sandbox" "--disable-dev-shm-usage"]}}}}})
