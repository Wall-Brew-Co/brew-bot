(ns brew-bot.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [brew-bot.recipe-generation-test]
            [brew-bot.ingredient-test]))

(doo-tests 'brew-bot.recipe-generation-test
           'brew-bot.ingredient-test)
