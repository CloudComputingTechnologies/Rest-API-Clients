package io.swagger.client.api

import io.swagger.client.model.Price
import org.joda.time.DateTime
import io.swagger.client.ApiInvoker
import io.swagger.client.ApiException

import com.sun.jersey.multipart.FormDataMultiPart
import com.sun.jersey.multipart.file.FileDataBodyPart

import javax.ws.rs.core.MediaType

import java.io.File
import java.util.Date

import scala.collection.mutable.HashMap

class PriceApi(val defBasePath: String = "http://localhost:15534",
                        defApiInvoker: ApiInvoker = ApiInvoker) {
  var basePath = defBasePath
  var apiInvoker = defApiInvoker

  def addHeader(key: String, value: String) = apiInvoker.defaultHeaders += key -> value 

  
  /**
   * 
   * 
   * @param apikey 
   * @param ticker 
   * @return List[Price]
   */
  def priceGetByTicker (apikey: String, ticker: String) : Option[List[Price]] = {
    // create path and map variables
    val path = "/Price/{ticker}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "ticker" + "\\}",apiInvoker.escape(ticker))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(apikey) != "null") queryParams += "apikey" -> apikey.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "array", classOf[Price]).asInstanceOf[List[Price]])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
  /**
   * 
   * 
   * @param apikey 
   * @param ticker 
   * @param date 
   * @return Price
   */
  def priceGet (apikey: String, ticker: String, date: DateTime) : Option[Price] = {
    // create path and map variables
    val path = "/Price/{ticker}/{date}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "ticker" + "\\}",apiInvoker.escape(ticker))

    .replaceAll("\\{" + "date" + "\\}",apiInvoker.escape(date))

    

    val contentTypes = List("application/json")
    val contentType = contentTypes(0)

    // query params
    val queryParams = new HashMap[String, String]
    val headerParams = new HashMap[String, String]
    val formParams = new HashMap[String, String]

    

    if(String.valueOf(apikey) != "null") queryParams += "apikey" -> apikey.toString
    
    
    

    var postBody: AnyRef = null

    if(contentType.startsWith("multipart/form-data")) {
      val mp = new FormDataMultiPart()
      
      postBody = mp
    }
    else {
      
    }

    try {
      apiInvoker.invokeApi(basePath, path, "GET", queryParams.toMap, formParams.toMap, postBody, headerParams.toMap, contentType) match {
        case s: String =>
           Some(ApiInvoker.deserialize(s, "", classOf[Price]).asInstanceOf[Price])
         
        case _ => None
      }
    } catch {
      case ex: ApiException if ex.code == 404 => None
      case ex: ApiException => throw ex
    }
  }
  
}
