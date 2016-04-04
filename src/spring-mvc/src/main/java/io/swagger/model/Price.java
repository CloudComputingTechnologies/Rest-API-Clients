package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-04-04T22:16:14.748+01:00")
public class Price  {
  
  private Date date = null;
  private String ticker = null;
  private Double value = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Date")
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Ticker")
  public String getTicker() {
    return ticker;
  }
  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("Value")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
  }

  

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Price price = (Price) o;
    return Objects.equals(date, price.date) &&
        Objects.equals(ticker, price.ticker) &&
        Objects.equals(value, price.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(date, ticker, value);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Price {\n");
    
    sb.append("  date: ").append(date).append("\n");
    sb.append("  ticker: ").append(ticker).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
