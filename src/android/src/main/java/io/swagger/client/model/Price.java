package io.swagger.client.model;

import java.util.Date;

import io.swagger.annotations.*;
import com.google.gson.annotations.SerializedName;


@ApiModel(description = "")
public class Price  {
  
  @SerializedName("Date")
  private Date date = null;
  @SerializedName("Ticker")
  private String ticker = null;
  @SerializedName("Value")
  private Double value = null;

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Date getDate() {
    return date;
  }
  public void setDate(Date date) {
    this.date = date;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public String getTicker() {
    return ticker;
  }
  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  
  /**
   **/
  @ApiModelProperty(value = "")
  public Double getValue() {
    return value;
  }
  public void setValue(Double value) {
    this.value = value;
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
