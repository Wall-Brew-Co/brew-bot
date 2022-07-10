## v3.1.0 / 2022 Jul 10

> This release migrates brew-bot to use common-beer-format types

* **Update** - Leverage `common-beer-format` v2.0.0, `common-beer-data` v1.0.0, and `brewtility` v1.2.0

## v3.0.0 / 2020 Aug 18

> This release introduces several breaking changes needed for long-term support.

* **Add** - Approximately a 20% increase in the number of ingredients supported via common-beer-format.
* **Fix** - Weighted selections now always add the same `:amount` to ensure weights are evenly distributed, rather than subject to addition amounts.
* **Fix** - Hop timings/use cases are now added to the IBU calculation, making it more accurate
* **Fix** - Yeast attenuation is now derived from manufacturer data, giving more accurate estimates for final gravity and ABV
* **Fix** - Color determinations now account for dilution more accurately
* **Update** - All recipe formats now conform to the common-beer-format
* **Update** - brew-bot is now distributed as part of the `com.wallbrew` group on clojars/maven
* **Remove** - All internal data for fermentables, hops, yeasts, styles. These have been permanently migrated to [common-beer-format](https://github.com/Wall-Brew-Co/common-beer-format)
* **Remove** - All internal calculations for abv, ibu, color. These have been permanently migrated to [brewtility](https://github.com/Wall-Brew-Co/brewtility)

## v2.2.0 / 2020 February 29

> Add BJCP style definitions and function to match recipes to styles

## v2.1.0 / 2020 February 25

> Refactor ingredients namespaces

## v2.0.0 / 2019 December 5

> ***BREAKING CHANGE*** - the UI and the library code are now separate
> Going forward, this repo will solely be used for the library code
> The website's code is now located at: https://github.com/nnichols/brew-bot-ui

## v1.0.0-gamma / 2019 November 27

> Systemic refactors toward common components, .cljc resources, and added config
> Overhaul of CI/CD auto-runners
> Add tagging to ingredients for better classification

## v1.0.0-beta / 2019 November 16

> Add static assets, routing via secretary

## v1.0.0-alpha2 / 2019 Oct 02

> Update mobile rendering

## v1.0.0-alpha1 / 2019 Oct 02

> Alpha launch to be hosted at nnichols.github.io

## v0.0.0 / 2019 July 13

> This release builds out all initial functionality
