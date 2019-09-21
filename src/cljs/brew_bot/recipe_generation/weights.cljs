(ns brew-bot.recipe-generation.weights
  "Pre-determined style weights based on beer recipe observation")

(def marzen
  {:hops {:tettnang-us  10.68892182
          :hallertau-us 25.05236668
          :saaz-us      7.357483668
          :mt-hood      2.576144593
          :magnum-us    1.979544194
          :perle-us     1.511896631
          :spalt        1.248175483
          :cascade      1.13507471
          :citra        1.035436256
          :celeia       1.000001277}
   :grains {:pilsner-2-row-german     132.239358813
            :vienna-malt              96.601216326
            :munich-malt              140.277328721
            :pale-malt-2-row-us       30.73503399
            :munich-malt-10l          18.7505104
            :smoked-malt              5.085036226
            :caramel-crystal-malt-60l 4.645640612
            :cara-munich-malt         16.925088429
            :munich-malt-20l          3.983955956
            :cara-red                 2.594228201
            :caramel-crystal-malt-40l 2.587184322
            :biscuit-malt             2.537679973
            :wheat-malt-belgian       2.125486261
            :caramel-crystal-malt-20l 2.117855046
            :aromatic-malt            1.701160994
            :cara-pils-dextrine       1.361163285
            :victory-malt             1.1905203}
   :extracts {:light-dry-extract       27.160894217
              :pilsner-liquid-extract  9.185916832
              :extra-light-dry-extract 2.619045026
              :amber-liquid-extract    14.486652325000001}
   :yeasts {:dcl-yeast-saflager-german-lager     68
            :white-labs-octoberfest-marzen-lager 27
            :wyeast-labs-bavarian-lager          36
            :brewtek-northern-german-lager       22
            :white-labs-german-ale-kolsch        21
            :dcl-yeast-safale-english-ale        23
            :white-labs-german-bock-lager        13
            :white-labs-southern-german-lager    11
            :wyeast-labs-german-ale              10
            :wyeast-labs-bohemian-lager          14
            :wyeast-labs-munich-lager            4
            :dcl-yeast-safbrew-ale               3
            :white-labs-california-ale           3
            :white-labs-dusseldorf-alt-yeast     2
            :wyeast-labs-california-lager        2
            :white-labs-german-ale-ii            2}})
