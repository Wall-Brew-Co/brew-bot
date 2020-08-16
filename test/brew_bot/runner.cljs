(ns brew-bot.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [brew-bot.core-test]
            [brew-bot.util-test]))

(doo-tests 'brew-bot.core-test
           'brew-bot.util-test)
