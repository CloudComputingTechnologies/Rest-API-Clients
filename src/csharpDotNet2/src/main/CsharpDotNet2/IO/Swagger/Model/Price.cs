using System;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model {

  /// <summary>
  /// 
  /// </summary>
  [DataContract]
  public class Price {
    
    /// <summary>
    /// Gets or Sets Date
    /// </summary>
    [DataMember(Name="Date", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "Date")]
    public DateTime? Date { get; set; }

    
    /// <summary>
    /// Gets or Sets Ticker
    /// </summary>
    [DataMember(Name="Ticker", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "Ticker")]
    public string Ticker { get; set; }

    
    /// <summary>
    /// Gets or Sets Value
    /// </summary>
    [DataMember(Name="Value", EmitDefaultValue=false)]
    [JsonProperty(PropertyName = "Value")]
    public double? Value { get; set; }

    

    /// <summary>
    /// Get the string presentation of the object
    /// </summary>
    /// <returns>String presentation of the object</returns>
    public override string ToString()  {
      var sb = new StringBuilder();
      sb.Append("class Price {\n");
      
      sb.Append("  Date: ").Append(Date).Append("\n");
      
      sb.Append("  Ticker: ").Append(Ticker).Append("\n");
      
      sb.Append("  Value: ").Append(Value).Append("\n");
      
      sb.Append("}\n");
      return sb.ToString();
    }

    /// <summary>
    /// Get the JSON string presentation of the object
    /// </summary>
    /// <returns>JSON string presentation of the object</returns>
    public string ToJson() {
      return JsonConvert.SerializeObject(this, Formatting.Indented);
    }

}
}
