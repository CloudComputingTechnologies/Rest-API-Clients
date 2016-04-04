package io.swagger.client.api {

import io.swagger.common.ApiInvoker;
import io.swagger.exception.ApiErrorCodes;
import io.swagger.exception.ApiError;
import io.swagger.common.ApiUserCredentials;
import io.swagger.event.Response;
import io.swagger.common.SwaggerApi;
import io.swagger.client.model.Price;

import mx.rpc.AsyncToken;
import mx.utils.UIDUtil;
import flash.utils.Dictionary;
import flash.events.EventDispatcher;

public class PriceApi extends SwaggerApi {
    /**
    * Constructor for the PriceApi api client
    * @param apiCredentials Wrapper object for tokens and hostName required towards authentication
    * @param eventDispatcher Optional event dispatcher that when provided is used by the SDK to dispatch any Response
    */
    public function PriceApi(apiCredentials: ApiUserCredentials, eventDispatcher: EventDispatcher = null) {
        super(apiCredentials, eventDispatcher);
    }

        public static const event_price_get_by_ticker: String = "price_get_by_ticker";
        public static const event_price_get: String = "price_get";


    /*
     * Returns Array 
     */
    public function price_get_by_ticker (apikey: String, ticker: String): String {
        // create path and map variables
        var path: String = "/Price/{ticker}".replace(/{format}/g,"xml").replace("{" + "ticker" + "}", getApiInvoker().escapeString(ticker));

        // query params
        var queryParams: Dictionary = new Dictionary();
        var headerParams: Dictionary = new Dictionary();

        

        if("null" != String(apikey))
            queryParams["apikey"] = toPathValue(apikey);
        

        

        var token:AsyncToken = getApiInvoker().invokeAPI(path, "GET", queryParams, null, headerParams);

        var requestId: String = getUniqueId();

        token.requestId = requestId;
        token.completionEventType = "price_get_by_ticker";

        token.returnType = Array;
        return requestId;

    }
    
    /*
     * Returns Price 
     */
    public function price_get (apikey: String, ticker: String, date: Date): String {
        // create path and map variables
        var path: String = "/Price/{ticker}/{date}".replace(/{format}/g,"xml").replace("{" + "ticker" + "}", getApiInvoker().escapeString(ticker)).replace("{" + "date" + "}", getApiInvoker().escapeString(date));

        // query params
        var queryParams: Dictionary = new Dictionary();
        var headerParams: Dictionary = new Dictionary();

        

        if("null" != String(apikey))
            queryParams["apikey"] = toPathValue(apikey);
        

        

        var token:AsyncToken = getApiInvoker().invokeAPI(path, "GET", queryParams, null, headerParams);

        var requestId: String = getUniqueId();

        token.requestId = requestId;
        token.completionEventType = "price_get";

        token.returnType = Price;
        return requestId;

    }
    
}
        
}
