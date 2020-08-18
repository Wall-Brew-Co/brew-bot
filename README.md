# brew-bot - The algorithmic beer recipe generator

![Github Runner](https://github.com/nnichols/brew-bot/workflows/Clojurescript%20CI/badge.svg)
[![Clojars Project](https://img.shields.io/clojars/v/brew-bot.svg)](https://clojars.org/brew-bot)
[![Dependencies Status](https://versions.deps.co/nnichols/brew-bot/status.svg)](https://versions.deps.co/nnichols/brew-bot)
[![cljdoc badge](https://cljdoc.org/badge/brew-bot/brew-bot)](https://cljdoc.org/d/brew-bot/brew-bot/CURRENT)

> We’re making beer. I’m the brewery!
> Bender Bending Rodriguez from [*Futurama*](https://www.imdb.com/title/tt0149460/)

A Clojure(Script) library to create randomized beer recipes!

The beta release of our SPA is now [available!](https://brewbot.wallbrew.com/)
If you're interested in contributing to the site, let us know.
That project can be found [here.](https://github.com/Wall-Brew-Co/brew-bot-ui)

## Installation

A deployed copy of the most recent version of [brew-bot can be found on clojars.](https://clojars.org/brew-bot)
To use it, add the following as a dependency in your project.clj file:

[![Clojars Project](http://clojars.org/brew-bot/latest-version.svg)](http://clojars.org/brew-bot)

The next time you build your application, [Leiningen](https://leiningen.org/) or [deps.edn](https://clojure.org/guides/deps_and_cli) should pull it automatically.
Alternatively, you may clone or fork the repository to work with it directly.

## Dependencies

This library heavily relies upon the [common-beer-format](https://github.com/Wall-Brew-Co/common-beer-format) and returns all recipes and ingredients to match its specification.
Therefore, all arguments passed to functions in brew-bot are normalized to these standards as well.
Most importantly, it assumes measurements are provided in the [International System of Units](https://en.wikipedia.org/wiki/International_System_of_Units), also known as the modern metric system.
Since many brewing applications, especially those based in America, operate on Imperial Measurements, you may wish to add [brewtility](https://github.com/Wall-Brew-Co/brewtility) to any applications consuming this library to assist with conversions between systems of measure.

## Usage

All functions necessary to generate a recipe are provided in the core namespace.

```clj
(:require [brew-bot.core :refer :all])

(def fermentables
  (select-fermentables))

(def hops
  (select-hops :random))

(def yeast
  (select-yeasts :random {:count-cutoff 1}))

(def my-random-recipe
  (ingredients->cbf-recipe-template fermentables hops yeast))
```

Each of the three functions `select-fermentables`, `select-hops`, and `select-yeasts` support multiple arities:

- Zero - Selects ingredients completely randomly across the full set provided by `common-beer-format`
- One - Given a strategy, select ingredients from the full set provided by `common-beer-format`
- Two - Given a strategy and a map of options, select ingredients with fine-grained control.

These are the currently supported strategies:

- `:random` - Select ingredients at random with an even probability of selection and with replacement
- `:weighted` - Select ingredients with a provided selection probability and with replacement. For example, `{:galaxy 15.0, :el-dorado 5.0, :topaz 1.0}`. In this example, galaxy hops have a 71.43% chance of being selected (15.0 / (15.0 + 5.0 + 1.0)).

These are the currently supported options:

- amount-cutoff - The maximum weight, in kilograms, of fermentable ingredients to select. Defaults to `2.26796` kilograms (5 pounds)
- count-cutoff - The maximum number of unique ingredients to allow.
- selection-weights - A map from ingredient names to probability weights. e.g. `{:amber-liquid-extract 5.0 :biscuit-malt 15.0 ...}`. Only applicable for the `:weighted` strategy
- default-weight - A probability weight to fall back to for ingredients not specified in selection-weights. Only applicable for the `:weighted` strategy

Additionally, per ingredient type, you may focus the possible ingredient selections.
Hops also support two additional options for determining when hops are added and their primary use case.

### Fermentables

- include-adjuncts? - A boolean switch to include adjuncts in the list of selectable ingredients. Defaults to `true`
- include-dry-extracts? - A boolean switch to include dry extracts in the list of selectable ingredients. Defaults to `true`
- include-extracts? - A boolean switch to include extracts in the list of selectable ingredients. Defaults to `true`
- include-grains? - A boolean switch to include grains in the list of selectable ingredients. Defaults to `true`
- include-sugars? - A boolean switch to include sugars in the list of selectable ingredients. Defaults to `true`

### Hops

- timing-strategy - A keyword from the set `#{:random :weighted :inferred}` to determine how hop timings and uses should be selected. Defaults to `:random`
- time-weights - A map from hop addition times to weights. e.g. `{120 60.0 45 15.0 ...}`
- use-weights - A map from hop use names to weights. e.g. `{"boil" 60 ...}`
- include-aroma? - A boolean switch to include aromatic hops. Defaults to `true`
- include-bittering? - A boolean switch to include bittering hops. Defaults to `true`
- include-both? - A boolean switch to include dual-purpose hops. Defaults to `true`

### Yeasts

- include-brewtek? - A boolean switch to include yeasts from Brewtek. Defaults to `true`
- include-dcl-fermentis? - A boolean switch to include yeasts from DCL Fermentis. Defaults to `true`
- include-lallemand? - A boolean switch to include yeasts from Lallemand. Defaults to `true`
- include-white-labs? - A boolean switch to include yeasts from White Labs. Defaults to `true`
- include-wyeast? - A boolean switch to include yeasts from Wyeast. Defaults to `true`

## Testing

[doo](https://github.com/bensu/doo), a Leiningen plugin used to run ClojureScript tests in many JS environments, is already in `project.clj`.
[Karma](https://karma-runner.github.io/latest/index.html) is used as the test runner, and is included in `package.json`.

To install Karma, simply install the Node package:

```shell
npm install
```

Then build the application and run the tests:

```shell
lein test-build
```

The tests will also execute on the JVM, to ensure the library is compatible for both runtime environments.

## License

Copyright © 2019-2020 - [Wall Brew Co](https://wallbrew.com/)

This software is provided for free, public use as outlined in the [MIT License](https://github.com/Wall-Brew-Co/brew-bot/blob/master/LICENSE)
