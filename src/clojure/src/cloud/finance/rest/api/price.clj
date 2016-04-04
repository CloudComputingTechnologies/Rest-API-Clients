(ns cloud/finance/rest.api.price
  (:require [cloud/finance/rest.core :refer [call-api check-required-params with-collection-format]])
  (:import (java.io File)))

(defn price-get-by-ticker-with-http-info
  ""
  [apikey ticker ]
  (call-api "/Price/{ticker}" :get
            {:path-params   {"ticker" ticker }
             :header-params {}
             :query-params  {"apikey" apikey }
             :form-params   {}
             :content-types []
             :accepts       ["application/json" "text/json" "application/xml" "text/xml"]
             :auth-names    []}))

(defn price-get-by-ticker
  ""
  [apikey ticker ]
  (:data (price-get-by-ticker-with-http-info apikey ticker)))

(defn price-get-with-http-info
  ""
  [apikey ticker date ]
  (call-api "/Price/{ticker}/{date}" :get
            {:path-params   {"ticker" ticker "date" date }
             :header-params {}
             :query-params  {"apikey" apikey }
             :form-params   {}
             :content-types []
             :accepts       ["application/json" "text/json" "application/xml" "text/xml"]
             :auth-names    []}))

(defn price-get
  ""
  [apikey ticker date ]
  (:data (price-get-with-http-info apikey ticker date)))
