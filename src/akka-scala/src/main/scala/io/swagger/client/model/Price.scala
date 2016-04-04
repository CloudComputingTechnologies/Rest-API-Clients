package io.swagger.client.model

import io.swagger.client.core.ApiModel
import org.joda.time.DateTime


case class Price (
  date: Option[DateTime],
  ticker: Option[String],
  value: Option[Double])
   extends ApiModel


