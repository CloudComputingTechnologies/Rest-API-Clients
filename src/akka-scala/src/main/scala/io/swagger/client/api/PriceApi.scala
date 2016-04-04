package io.swagger.client.api

import io.swagger.client.model.Price
import org.joda.time.DateTime
import io.swagger.client.core._
import io.swagger.client.core.CollectionFormats._
import io.swagger.client.core.ApiKeyLocations._

object PriceApi {

  /**
   * 
   * 
   * Expected answers:
   *   code 200 : Seq[Price] (OK)
   * 
   * @param apikey 
   * @param ticker 
   */
  def priceGetByTicker(apikey: String, ticker: String): ApiRequest[Seq[Price]] =
    ApiRequest[Seq[Price]](ApiMethods.GET, "http://localhost:15534", "/Price/{ticker}", "application/json")
      .withQueryParam("apikey", apikey)
      .withPathParam("ticker", ticker)
      .withSuccessResponse[Seq[Price]](200)
      
  /**
   * 
   * 
   * Expected answers:
   *   code 200 : Price (OK)
   * 
   * @param apikey 
   * @param ticker 
   * @param date 
   */
  def priceGet(apikey: String, ticker: String, date: DateTime): ApiRequest[Price] =
    ApiRequest[Price](ApiMethods.GET, "http://localhost:15534", "/Price/{ticker}/{date}", "application/json")
      .withQueryParam("apikey", apikey)
      .withPathParam("ticker", ticker)
      .withPathParam("date", date)
      .withSuccessResponse[Price](200)
      


}

