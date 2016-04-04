// require files in Node.js environment
var $, Price;
if (typeof module === 'object' && module.exports) {
  $ = require('jquery');
  Price = require('../model/Price.js');
}

// export module for AMD
if ( typeof define === "function" && define.amd ) {     
	define(['jquery', 'Price'], function($, Price) {
        return PriceApi;
	 });
}

var PriceApi = function PriceApi() {
	var self = this;
  
  
  /**
   * 
   * 
   * @param {String}  apikey 
   * @param {String}  ticker 
   * @param {function} callback the callback function
   * @return Array
   */
  self.priceGetByTicker = function(apikey, ticker, callback) {
    var postBody = null;
    var postBinaryBody = null;
    
     // verify the required parameter 'apikey' is set
     if (apikey == null) {
        //throw new ApiException(400, "Missing the required parameter 'apikey' when calling priceGetByTicker");
        var errorRequiredMsg = "Missing the required parameter 'apikey' when calling priceGetByTicker";
        throw errorRequiredMsg;
     }
     
     // verify the required parameter 'ticker' is set
     if (ticker == null) {
        //throw new ApiException(400, "Missing the required parameter 'ticker' when calling priceGetByTicker");
        var errorRequiredMsg = "Missing the required parameter 'ticker' when calling priceGetByTicker";
        throw errorRequiredMsg;
     }
     
    // create path and map variables
    var basePath = 'http://localhost:15534';
    // if basePath ends with a /, remove it as path starts with a leading /
    if (basePath.substring(basePath.length-1, basePath.length)=='/') {
    	basePath = basePath.substring(0, basePath.length-1);
    }
    
    var path = basePath + replaceAll(replaceAll("/Price/{ticker}", "\\{format\\}","json")
, "\\{" + "ticker" + "\\}", encodeURIComponent(ticker.toString()));

    var queryParams = {};
    var headerParams =  {};
    var formParams =  {};

    
    queryParams.apikey = apikey;
    
    
    

    path += createQueryString(queryParams);

    var options = {type: "GET", async: true, contentType: "application/json", dataType: "json", data: postBody};
    var request = $.ajax(path, options);

    request.fail(function(jqXHR, textStatus, errorThrown){
      if (callback) {
        var error = errorThrown || textStatus || jqXHR.statusText || 'error';
        callback(null, textStatus, jqXHR, error);
      }
    });
		
    request.done(function(response, textStatus, jqXHR){
      
      /**
        * @returns Array
        */
      
      var myResponse = new Array();
      myResponse.constructFromObject(response);
      if (callback) {
        callback(myResponse, textStatus, jqXHR);
      }
      
    });
 
    return request;
  }
  
  /**
   * 
   * 
   * @param {String}  apikey 
   * @param {String}  ticker 
   * @param {Date}  date 
   * @param {function} callback the callback function
   * @return Price
   */
  self.priceGet = function(apikey, ticker, date, callback) {
    var postBody = null;
    var postBinaryBody = null;
    
     // verify the required parameter 'apikey' is set
     if (apikey == null) {
        //throw new ApiException(400, "Missing the required parameter 'apikey' when calling priceGet");
        var errorRequiredMsg = "Missing the required parameter 'apikey' when calling priceGet";
        throw errorRequiredMsg;
     }
     
     // verify the required parameter 'ticker' is set
     if (ticker == null) {
        //throw new ApiException(400, "Missing the required parameter 'ticker' when calling priceGet");
        var errorRequiredMsg = "Missing the required parameter 'ticker' when calling priceGet";
        throw errorRequiredMsg;
     }
     
     // verify the required parameter 'date' is set
     if (date == null) {
        //throw new ApiException(400, "Missing the required parameter 'date' when calling priceGet");
        var errorRequiredMsg = "Missing the required parameter 'date' when calling priceGet";
        throw errorRequiredMsg;
     }
     
    // create path and map variables
    var basePath = 'http://localhost:15534';
    // if basePath ends with a /, remove it as path starts with a leading /
    if (basePath.substring(basePath.length-1, basePath.length)=='/') {
    	basePath = basePath.substring(0, basePath.length-1);
    }
    
    var path = basePath + replaceAll(replaceAll("/Price/{ticker}/{date}", "\\{format\\}","json")
, "\\{" + "ticker" + "\\}", encodeURIComponent(ticker.toString())
, "\\{" + "date" + "\\}", encodeURIComponent(date.toString()));

    var queryParams = {};
    var headerParams =  {};
    var formParams =  {};

    
    queryParams.apikey = apikey;
    
    
    

    path += createQueryString(queryParams);

    var options = {type: "GET", async: true, contentType: "application/json", dataType: "json", data: postBody};
    var request = $.ajax(path, options);

    request.fail(function(jqXHR, textStatus, errorThrown){
      if (callback) {
        var error = errorThrown || textStatus || jqXHR.statusText || 'error';
        callback(null, textStatus, jqXHR, error);
      }
    });
		
    request.done(function(response, textStatus, jqXHR){
      
      /**
        * @returns Price
        */
      
      var myResponse = new Price();
      myResponse.constructFromObject(response);
      if (callback) {
        callback(myResponse, textStatus, jqXHR);
      }
      
    });
 
    return request;
  }
  
  

 	function replaceAll (haystack, needle, replace) {
		var result= haystack;
		if (needle !=null && replace!=null) {
			result= haystack.replace(new RegExp(needle, 'g'), replace);
		}
		return result;
	}

 	function createQueryString (queryParams) {
		var queryString ='';
		var i = 0;
		for (var queryParamName in queryParams) {
			if (i==0) {
				queryString += '?' ;
			} else {
				queryString += '&' ;
			}
			
			queryString +=  queryParamName + '=' + encodeURIComponent(queryParams[queryParamName]);
			i++;
		}
		
		return queryString;
	}
}

// export module for Node.js
if (typeof module === 'object' && module.exports) {
  module.exports = PriceApi;
}
