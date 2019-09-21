# brew-bot - The algorithmic beer recipe generator
<a href="https://icons8.com/icon/66359/wooden-beer-keg"><img src="resources/icons8-wooden-beer-keg.png"></a>

![Github Runner](https://github.com/nnichols/brew-bot/workflows/Clojure%20CI/badge.svg)

> We’re making beer. I’m the brewery!
> - Bender Bending Rodriguez from [*Futurama*](https://www.imdb.com/title/tt0149460/)

# brew-bot

Bot that spits out brew recipes for n-gallon batches.
Originally made for [wallbrew.com](https://wallbrew.com/)

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

Then open `index.html` in the browser of your choice.

## Testing

Test build + execution via [PhantomJS](https://phantomjs.org/):
```
lein test-build
```

## License

Copyright © 2019 Nick Nichols

Distributed under the Eclipse Public License either version 1.0 or (at your option) any later version.

[Wooden Beer Keg Icon by Icons8](https://icons8.com/icon/66359/wooden-beer-keg)
