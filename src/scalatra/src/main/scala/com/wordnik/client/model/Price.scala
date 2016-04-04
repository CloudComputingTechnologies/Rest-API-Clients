package com.wordnik.client.model

import java.util.Date


case class Price (
  Date: Date,
  Ticker: String,
  Value: Double
)
