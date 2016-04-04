using System;
using System.Linq;
using System.IO;
using System.Text;
using System.Collections;
using System.Collections.Generic;
using System.Runtime.Serialization;
using Newtonsoft.Json;

namespace IO.Swagger.Model
{

    /// <summary>
    /// 
    /// </summary>
    [DataContract]
    public class Price :  IEquatable<Price>
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="Price" /> class.
        /// </summary>
        public Price()
        {
            
        }

        
        /// <summary>
        /// Gets or Sets Date
        /// </summary>
        [DataMember(Name="Date", EmitDefaultValue=false)]
        public DateTime? Date { get; set; }
  
        
        /// <summary>
        /// Gets or Sets Ticker
        /// </summary>
        [DataMember(Name="Ticker", EmitDefaultValue=false)]
        public string Ticker { get; set; }
  
        
        /// <summary>
        /// Gets or Sets Value
        /// </summary>
        [DataMember(Name="Value", EmitDefaultValue=false)]
        public double? Value { get; set; }
  
        
  
        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            var sb = new StringBuilder();
            sb.Append("class Price {\n");
            sb.Append("  Date: ").Append(Date).Append("\n");
            sb.Append("  Ticker: ").Append(Ticker).Append("\n");
            sb.Append("  Value: ").Append(Value).Append("\n");
            
            sb.Append("}\n");
            return sb.ToString();
        }
  
        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public string ToJson()
        {
            return JsonConvert.SerializeObject(this, Formatting.Indented);
        }

        /// <summary>
        /// Returns true if objects are equal
        /// </summary>
        /// <param name="obj">Object to be compared</param>
        /// <returns>Boolean</returns>
        public override bool Equals(object obj)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            return this.Equals(obj as Price);
        }

        /// <summary>
        /// Returns true if Price instances are equal
        /// </summary>
        /// <param name="obj">Instance of Price to be compared</param>
        /// <returns>Boolean</returns>
        public bool Equals(Price other)
        {
            // credit: http://stackoverflow.com/a/10454552/677735
            if (other == null)
                return false;

            return 
                (
                    this.Date == other.Date ||
                    this.Date != null &&
                    this.Date.Equals(other.Date)
                ) && 
                (
                    this.Ticker == other.Ticker ||
                    this.Ticker != null &&
                    this.Ticker.Equals(other.Ticker)
                ) && 
                (
                    this.Value == other.Value ||
                    this.Value != null &&
                    this.Value.Equals(other.Value)
                );
        }

        /// <summary>
        /// Gets the hash code
        /// </summary>
        /// <returns>Hash code</returns>
        public override int GetHashCode()
        {
            // credit: http://stackoverflow.com/a/263416/677735
            unchecked // Overflow is fine, just wrap
            {
                int hash = 41;
                // Suitable nullity checks etc, of course :)
                
                if (this.Date != null)
                    hash = hash * 57 + this.Date.GetHashCode();
                
                if (this.Ticker != null)
                    hash = hash * 57 + this.Ticker.GetHashCode();
                
                if (this.Value != null)
                    hash = hash * 57 + this.Value.GetHashCode();
                
                return hash;
            }
        }

    }
}
