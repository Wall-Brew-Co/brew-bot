(defproject brew-bot "0.1.0-SNAPSHOT"
  :description "A quick, dirty way to get randomized beer recipes"
  :url "https://github.com/nnichols/brew-bot"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot brew-bot.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
