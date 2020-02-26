(ns brew-bot.runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [brew-bot.recipe-generation-test]
            [brew-bot.ingredient-test]
            [brew-bot.ingredient-lists.yeasts-test]
<<<<<<< HEAD
            [brew-bot.style-lists.weight-test]
            [brew-bot.style-lists.pilsner-test]))
=======
            [brew-bot.weight-test]))
>>>>>>> master

(doo-tests 'brew-bot.recipe-generation-test
           'brew-bot.ingredient-test
           'brew-bot.ingredient-lists.yeasts-test
<<<<<<< HEAD
           'brew-bot.style-lists.weight-test
           'brew-bot.style-lists.pilsner-test)
=======
           'brew-bot.weight-test)
>>>>>>> master
