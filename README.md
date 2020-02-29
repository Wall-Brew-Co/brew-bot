# brew-bot - The algorithmic beer recipe generator
<a href="https://icons8.com/icon/66359/wooden-beer-keg"><img src="resources/icons8-wooden-beer-keg.png"></a>

![Github Runner](https://github.com/nnichols/brew-bot/workflows/Clojurescript%20CI/badge.svg)
[![Clojars Project](https://img.shields.io/clojars/v/brew-bot.svg)](https://clojars.org/brew-bot)
[![Dependencies Status](https://versions.deps.co/nnichols/brew-bot/status.svg)](https://versions.deps.co/nnichols/brew-bot)
[![cljdoc badge](https://cljdoc.org/badge/brew-bot/brew-bot)](https://cljdoc.org/d/brew-bot/brew-bot/CURRENT)

> We’re making beer. I’m the brewery!
> - Bender Bending Rodriguez from [*Futurama*](https://www.imdb.com/title/tt0149460/)

# brew-bot

A library that spits out brew recipes for n-gallon beer batches.
Originally made for [wallbrew.com](https://wallbrew.com/)

The beta release of our SPA is now [available!](https://nnichols.github.io/brew-bot/)
If you're interested in contributing to the site, let us know.
That project can be found [here.](https://github.com/nnichols/brew-bot-ui)

## Recipe Generators

* **Purely Random** - brew-bot will randomly select ingredients and quantities up to the set weight limit.
* **Constrained Random** - brew-bot will randomly select ingredients and quantities up to the set weight limit, selecting no more ingredients than the set limit.
* **Weighted Random** - brew-bot will allow the user to select ingredients to adjust their relative selection probabilities, and randomly pick ingredients from the full list respecting the user-selected weights.
* **Weighted Guided** - brew-bot will allow the user to select ingredients to adjust their relative selection probabilities, and randomly pick ingredients from the that list respecting the user-selected weights.
* **COMING SOON: Weighted Observed** - brew-bot will utilize weights learned from scraping real world beer recipes by style.

## BJCP Conformance

brew-bot also maintains the data included in the [**Beer Judge Certification Program** (BJCP)](https://www.bjcp.org/) to determine recipe styles and characteristics.
This data can be utilized to determine what characteristics the generated recipes may have, and which traditional styles they may represent.
The 2015 stlye guidelines are currently the only represented of the program's judging history.

## Installation

A deployed copy of the most recent version of [brew-bot can be found on clojars.](https://clojars.org/brew-bot)
To use it, add the following as a dependency in your project.clj file:

[![Clojars Project](http://clojars.org/brew-bot/latest-version.svg)](http://clojars.org/brew-bot)

The next time you build your application, [Leiningen](https://leiningen.org/) should pull it automatically.
Alternatively, you may clone or fork the repository to work with it directly.

## Testing

[doo](https://github.com/bensu/doo), a Leiningen plugin used to run ClojureScript tests in many JS environments, is already in `project.clj`.
[Karma](https://karma-runner.github.io/latest/index.html) is used as the test runner, and is included in `package.json`.

To install Karma, simply install the Node package:
```
npm install
```

Then build the application and run the tests:
```
lein test-build
```

The tests will also execute on the JVM, to ensure the library is compatible for apps thick and thin.

## License

Copyright © 2019-2020 Nick Nichols

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.

[Wooden Beer Keg Icon by Icons8](https://icons8.com/icon/66359/wooden-beer-keg)
