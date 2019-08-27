(ns brew-bot.runner
    (:require [doo.runner :refer-macros [doo-tests]]
              [brew-bot.core-test]
              [brew-bot.ingredient-test]))

(doo-tests 'brew-bot.core-test
           'brew-bot.ingredient-test)
