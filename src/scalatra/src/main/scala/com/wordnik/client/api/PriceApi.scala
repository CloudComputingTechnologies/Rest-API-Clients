package com.wordnik.client.api

import com.wordnik.client.model.Price
import java.util.Date

import java.io.File

import org.scalatra.{ TypedParamSupport, ScalatraServlet }
import org.scalatra.swagger._
import org.json4s._
import org.json4s.JsonDSL._
import org.scalatra.json.{ JValueResult, JacksonJsonSupport }
import org.scalatra.servlet.{FileUploadSupport, MultipartConfig, SizeConstraintExceededException}

import scala.collection.JavaConverters._

class PriceApi (implicit val swagger: Swagger) extends ScalatraServlet 
    with FileUploadSupport
    with JacksonJsonSupport
    with SwaggerSupport {
  protected implicit val jsonFormats: Formats = DefaultFormats

  protected val applicationDescription: String = "PriceApi"
  override protected val applicationName: Option[String] = Some("Price")

  before() {
    contentType = formats("json")
    response.headers += ("Access-Control-Allow-Origin" -> "*")
  }
  

  val priceGetByTickerOperation = (apiOperation[List[Price]]("priceGetByTicker")
      summary ""
      parameters(queryParam[String]("apikey").description(""),
        pathParam[String]("ticker").description(""))
  )

  get("/Price/{ticker}",operation(priceGetByTickerOperation)) {
    
    
    
        
      
      val apikey = params.getAs[String]("apikey")
            

    
    println("apikey: " + apikey)
  
    
    
      val ticker = params.getOrElse("ticker", halt(400))
                

    
    println("ticker: " + ticker)
  
  }

  

  val priceGetOperation = (apiOperation[Price]("priceGet")
      summary ""
      parameters(queryParam[String]("apikey").description(""),
        pathParam[String]("ticker").description(""),
        pathParam[Date]("date").description(""))
  )

  get("/Price/{ticker}/{date}",operation(priceGetOperation)) {
    
    
    
        
      
      val apikey = params.getAs[String]("apikey")
            

    
    println("apikey: " + apikey)
  
    
    
      val ticker = params.getOrElse("ticker", halt(400))
                

    
    println("ticker: " + ticker)
  
    
    
      val date = params.getOrElse("date", halt(400))
                

    
    println("date: " + date)
  
  }

}