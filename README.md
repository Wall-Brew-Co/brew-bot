# brew-bot - The algorithmic beer recipe generator

![Github Runner](https://github.com/nnichols/brew-bot/workflows/Clojurescript%20CI/badge.svg)
[![Clojars Project](https://img.shields.io/clojars/v/brew-bot.svg)](https://clojars.org/brew-bot)
[![Dependencies Status](https://versions.deps.co/nnichols/brew-bot/status.svg)](https://versions.deps.co/nnichols/brew-bot)
[![cljdoc badge](https://cljdoc.org/badge/brew-bot/brew-bot)](https://cljdoc.org/d/brew-bot/brew-bot/CURRENT)

> We’re making beer. I’m the brewery!
> - Bender Bending Rodriguez from [*Futurama*](https://www.imdb.com/title/tt0149460/)

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
To start, we'll need to select some ingredients:

```clj
(:require [brew-bot.core :refer :all])


(def fermentable
  (select-fermentables :random {:count-cutoff 3}))

```


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
