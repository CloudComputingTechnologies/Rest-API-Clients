// require files in Node.js environment

if (typeof module === 'object' && module.exports) {
  
}




//export module
if ( typeof define === "function" && define.amd ) {
  define('Price', ['jquery'],
    function($) {
      return Price;
   });
}


var Price = function Price() { 
  var self = this;
  
  /**
   * datatype: Date
   **/
  self.date = null;
  
  /**
   * datatype: String
   **/
  self.ticker = null;
  
  /**
   * datatype: Number
   **/
  self.value = null;
  
  
  self.constructFromObject = function(data) {
    if (!data) {
      return;
    }
    
    self.date = data.Date;
    
    self.ticker = data.Ticker;
    
    self.value = data.Value;
    
  }

  
  /**
   * @return {Date}
   **/
  self.getDate = function() {
    return self.date;
  }

  /**
   * @param {Date} date
   **/
  self.setDate = function (date) {
    self.date = date;
  }
  
  /**
   * @return {String}
   **/
  self.getTicker = function() {
    return self.ticker;
  }

  /**
   * @param {String} ticker
   **/
  self.setTicker = function (ticker) {
    self.ticker = ticker;
  }
  
  /**
   * @return {Number}
   **/
  self.getValue = function() {
    return self.value;
  }

  /**
   * @param {Number} value
   **/
  self.setValue = function (value) {
    self.value = value;
  }
  

  self.toJson = function () {
    return JSON.stringify(self);
  }
}

if (typeof module === 'object' && module.exports) {
  module.exports = Price;
}
