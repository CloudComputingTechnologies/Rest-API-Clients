package io.swagger.client.model {


    [XmlRootNode(name="Price")]
    public class Price {
        
        
        
        [XmlElement(name="Date")]
        
        public var date: Date = null;
    
        
        
        [XmlElement(name="Ticker")]
        
        public var ticker: String = null;
    
        
        
        [XmlElement(name="Value")]
        
        public var value: Number = 0.0;
    

    public function toString(): String {
        var str: String = "Price: ";
        
        str += " (date: " + date + ")";
        
        str += " (ticker: " + ticker + ")";
        
        str += " (value: " + value + ")";
        
        return str;
    }

}

}
