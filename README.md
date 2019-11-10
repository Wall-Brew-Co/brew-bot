# brew-bot - The algorithmic beer recipe generator
<a href="https://icons8.com/icon/66359/wooden-beer-keg"><img src="resources/public/icons8-wooden-beer-keg.png"></a>

![Github Runner](https://github.com/nnichols/brew-bot/workflows/Clojure%20CI/badge.svg)

> We’re making beer. I’m the brewery!
> - Bender Bending Rodriguez from [*Futurama*](https://www.imdb.com/title/tt0149460/)

# brew-bot

Bot that spits out brew recipes for n-gallon batches.
Originally made for [wallbrew.com](https://wallbrew.com/)

The alpha release is now [available!](https://nnichols.github.io/brew-bot/)

brew-bot is a re-frame SPA used to generate random beer recipes based on various weighting schemes:

* **Purely Random** - brew-bot will randomly select ingredients and quantities up to the set weight limit.
* **Constrained Random** - brew-bot will randomly select ingredients and quantities up to the set weight limit, selecting no more ingredients than the set limit.
* **Weighted Random** - brew-bot will allow the user to select ingredients to adjust their relative selection probabilities, and randomly pick ingredients from the full list respecting the user-selected weights.
* **Weighted Guided** - brew-bot will allow the user to select ingredients to adjust their relative selection probabilities, and randomly pick ingredients from the that list respecting the user-selected weights.
* **COMING SOON: Weighted Observed** - brew-bot will utilize weights learned from scraping real world beer recipes by style.


## Installation

Production build:
```
lein prod-build
```

Dev/Figwheel build:
```
lein dev-build
lein figwheel
```

Then, open `resources/public/index.html` in the browser of your choice.

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

## License

Copyright © 2019 Nick Nichols

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.

[Wooden Beer Keg Icon by Icons8](https://icons8.com/icon/66359/wooden-beer-keg)
