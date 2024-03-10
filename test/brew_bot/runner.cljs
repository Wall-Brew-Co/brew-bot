(ns brew-bot.runner
  (:require [brew-bot.core-test]
            [brew-bot.util-test]
            [doo.runner :refer-macros [doo-tests]]))


(doo-tests 'brew-bot.core-test
           'brew-bot.util-test)
