package io.swagger.client.api

import io.swagger.client.model.Price
import org.joda.time.DateTime
import io.swagger.client._
import scala.concurrent.{ Future, Await }
import scala.concurrent.duration._
import collection.mutable

class PriceApi(client: TransportClient, config: SwaggerConfig) extends ApiClient(client, config) {

  
  def priceGetByTicker(apikey: String,
      ticker: String)(implicit reader: ClientResponseReader[List[Price]]): Future[List[Price]] = {
    // create path and map variables
    val path = (addFmt("/Price/{ticker}")
        replaceAll ("\\{" + "ticker" + "\\}",ticker.toString))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]

    

    
    if(apikey != null)   queryParams += "apikey" -> apikey.toString

    

    val resFuture = client.submit("GET", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }

  
  def priceGet(apikey: String,
      ticker: String,
      date: DateTime)(implicit reader: ClientResponseReader[Price]): Future[Price] = {
    // create path and map variables
    val path = (addFmt("/Price/{ticker}/{date}")
        replaceAll ("\\{" + "ticker" + "\\}",ticker.toString)
        replaceAll ("\\{" + "date" + "\\}",date.toString))

    // query params
    val queryParams = new mutable.HashMap[String, String]
    val headerParams = new mutable.HashMap[String, String]

    

    
    if(apikey != null)   queryParams += "apikey" -> apikey.toString

    

    val resFuture = client.submit("GET", path, queryParams.toMap, headerParams.toMap, "")
    resFuture flatMap { resp =>
      process(reader.read(resp))
    }
  }

  

}
