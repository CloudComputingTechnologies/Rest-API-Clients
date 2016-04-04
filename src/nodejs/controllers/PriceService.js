'use strict';

exports.priceGetByTicker = function(args, res, next) {
  /**
   * parameters expected in the args:
   * apikey (String)
   * ticker (String)
   **/

var examples = {};
  
  examples['application/json'] = [ {
  "Ticker" : "aeiou",
  "Value" : 1.3579000000000001069366817318950779736042022705078125,
  "Date" : "2016-04-04T21:09:10.847+0000"
} ];
  

  
  if(Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  }
  else {
    res.end();
  }
  
  
}
exports.priceGet = function(args, res, next) {
  /**
   * parameters expected in the args:
   * apikey (String)
   * ticker (String)
   * date (Date)
   **/

var examples = {};
  
  examples['application/json'] = {
  "Ticker" : "aeiou",
  "Value" : 1.3579000000000001069366817318950779736042022705078125,
  "Date" : "2016-04-04T21:09:10.892+0000"
};
  

  
  if(Object.keys(examples).length > 0) {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(examples[Object.keys(examples)[0]] || {}, null, 2));
  }
  else {
    res.end();
  }
  
  
}
