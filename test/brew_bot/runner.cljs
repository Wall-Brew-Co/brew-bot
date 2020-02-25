(ns brew-bot.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [brew-bot.recipe-generation-test]
            [brew-bot.ingredient-test]
            [brew-bot.ingredient-lists.yeasts-test]
            [brew-bot.weight-test]))

(doo-tests 'brew-bot.recipe-generation-test
           'brew-bot.ingredient-test
           'brew-bot.ingredient-lists.yeasts-test
           'brew-bot.weight-test)
