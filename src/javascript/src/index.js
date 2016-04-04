if (typeof module === 'object' && module.exports) {
  var CloudFinanceRest = {};
  
  CloudFinanceRest.Price = require('./model/Price.js');
  
  
  CloudFinanceRest.PriceApi = require('./api/PriceApi.js');
  
  module.exports = CloudFinanceRest;
}