(ns brew-bot.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [brew-bot.core-test]))

(doo-tests 'brew-bot.core-test)
