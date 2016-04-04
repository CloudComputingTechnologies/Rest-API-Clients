package io.swagger.client

import io.swagger.client.api._

import io.swagger.client._

import java.io.Closeable

class SwaggerClient(config: SwaggerConfig) extends Closeable {
  val locator = config.locator
  val name = config.name

  private[this] val client = transportClient

  protected def transportClient: TransportClient = new RestClient(config)
  
  val price = new PriceApi(client, config)
  

  def close() {
    client.close()
  }
}