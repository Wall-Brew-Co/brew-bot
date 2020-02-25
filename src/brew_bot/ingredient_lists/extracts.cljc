(ns brew-bot.ingredient-lists.extracts
  "Data for malt extracts and brewing sugars")

(def ^:const extracts
  {:amber-dry-extract {:name "Amber Dry Extract"
                       :gravity 1.044
                       :lovibond 35
                       :suggested-max 100.0}
   :amber-liquid-extract {:name "Amber Liquid Extract"
                          :gravity 1.036
                          :lovibond 35
                          :suggested-max 100.0}
   :belgian-candi-syrup-45l {:name "Belgian Candi Syrup - 45L"
                             :gravity 1.032
                             :lovibond 45
                             :suggested-max 20.0}
   :belgian-candi-syrup-90l {:name "Belgian Candi Syrup - 90L"
                             :gravity 1.032
                             :lovibond 90
                             :suggested-max 20.0}
   :belgian-candi-syrup-180l {:name "Belgian Candi Syrup - 180L"
                              :gravity 1.032
                              :lovibond 180
                              :suggested-max 20.0}
   :dark-dry-extract {:name "Dark Dry Extract"
                      :gravity 1.044
                      :lovibond 60
                      :suggested-max 100.0}
   :dark-liquid-extract {:name "Dark Liquid Extract"
                         :gravity 1.036
                         :lovibond 60
                         :suggested-max 100.0}
   :extra-light-dry-extract {:name "Extra Light Dry Extract"
                             :gravity 1.044
                             :lovibond 6
                             :suggested-max 100.0}
   :light-dry-extract {:name "Light Dry Extract"
                       :gravity 1.044
                       :lovibond 6
                       :suggested-max 100.0}
   :pale-liquid-extract {:name "Pale Liquid Extract"
                         :gravity 1.036
                         :lovibond 3
                         :suggested-max 100.0}
   :pilsner-liquid-extract {:name "Pilsner Liquid Extract"
                            :gravity 1.036
                            :lovibond 3
                            :suggested-max 100.0}
   :rice-liquid-extract {:name "Rice Extract Syrup"
                         :gravity 1.032
                         :lovibond 8
                         :suggested-max 15.0}
   :rye-liquid-extract {:name "Rye Liquid Extract"
                        :gravity 1.036
                        :lovibond 9
                        :suggested-max 100.0}
   :wheat-dry-extract {:name "Wheat Dry Extract"
                       :gravity 1.044
                       :lovibond 12
                       :suggested-max 100.0}
   :wheat-liquid-extract {:name "Wheat Liquid Extract"
                          :gravity 1.036
                          :lovibond 12
                          :suggested-max 100.0}})
