package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;





@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-04-04T22:12:46.614+01:00")
public class Price   {
  
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
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Price {\n");
    
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    ticker: ").append(toIndentedString(ticker)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

