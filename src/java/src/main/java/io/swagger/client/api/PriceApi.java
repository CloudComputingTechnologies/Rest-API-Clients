package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;

import io.swagger.client.model.Price;
import java.util.Date;

import java.util.*;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-04-04T22:07:43.159+01:00")
public class PriceApi {
  private ApiClient apiClient;

  public PriceApi() {
    this(Configuration.getDefaultApiClient());
  }

  public PriceApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  
  /**
   * 
   * 
   * @param apikey 
   * @param ticker 
   * @return List<Price>
   */
  public List<Price> priceGetByTicker(String apikey, String ticker) throws ApiException {
    Object postBody = null;
    
     // verify the required parameter 'apikey' is set
     if (apikey == null) {
        throw new ApiException(400, "Missing the required parameter 'apikey' when calling priceGetByTicker");
     }
     
     // verify the required parameter 'ticker' is set
     if (ticker == null) {
        throw new ApiException(400, "Missing the required parameter 'ticker' when calling priceGetByTicker");
     }
     
    // create path and map variables
    String path = "/Price/{ticker}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "ticker" + "\\}", apiClient.escapeString(ticker.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "apikey", apikey));
    

    

    

    final String[] accepts = {
      "application/json", "text/json", "application/xml", "text/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    GenericType<List<Price>> returnType = new GenericType<List<Price>>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
  /**
   * 
   * 
   * @param apikey 
   * @param ticker 
   * @param date 
   * @return Price
   */
  public Price priceGet(String apikey, String ticker, Date date) throws ApiException {
    Object postBody = null;
    
     // verify the required parameter 'apikey' is set
     if (apikey == null) {
        throw new ApiException(400, "Missing the required parameter 'apikey' when calling priceGet");
     }
     
     // verify the required parameter 'ticker' is set
     if (ticker == null) {
        throw new ApiException(400, "Missing the required parameter 'ticker' when calling priceGet");
     }
     
     // verify the required parameter 'date' is set
     if (date == null) {
        throw new ApiException(400, "Missing the required parameter 'date' when calling priceGet");
     }
     
    // create path and map variables
    String path = "/Price/{ticker}/{date}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "ticker" + "\\}", apiClient.escapeString(ticker.toString()))
      .replaceAll("\\{" + "date" + "\\}", apiClient.escapeString(date.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, Object> formParams = new HashMap<String, Object>();

    
    queryParams.addAll(apiClient.parameterToPairs("", "apikey", apikey));
    

    

    

    final String[] accepts = {
      "application/json", "text/json", "application/xml", "text/xml"
    };
    final String accept = apiClient.selectHeaderAccept(accepts);

    final String[] contentTypes = {
      
    };
    final String contentType = apiClient.selectHeaderContentType(contentTypes);

    String[] authNames = new String[] {  };

    
    GenericType<Price> returnType = new GenericType<Price>() {};
    return apiClient.invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    
  }
  
}
