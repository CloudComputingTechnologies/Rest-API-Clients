package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.ApiInvoker;
import io.swagger.client.Pair;

import io.swagger.client.model.*;

import java.util.*;

import io.swagger.client.model.Price;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.util.Map;
import java.util.HashMap;
import java.io.File;

public class PriceApi {
  String basePath = "http://localhost:15534";
  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public void addHeader(String key, String value) {
    getInvoker().addDefaultHeader(key, value);
  }

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getBasePath() {
    return basePath;
  }

  
  /**
   * 
   * 
   * @param apikey 
   * @param ticker 
   * @return List<Price>
   */
  public List<Price>  priceGetByTicker (String apikey, String ticker) throws ApiException {
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
    String path = "/Price/{ticker}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "ticker" + "\\}", apiInvoker.escapeString(ticker.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "apikey", apikey));
    

    

    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = builder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (List<Price>) ApiInvoker.deserialize(response, "array", Price.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
  /**
   * 
   * 
   * @param apikey 
   * @param ticker 
   * @param date 
   * @return Price
   */
  public Price  priceGet (String apikey, String ticker, Date date) throws ApiException {
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
    String path = "/Price/{ticker}/{date}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "ticker" + "\\}", apiInvoker.escapeString(ticker.toString())).replaceAll("\\{" + "date" + "\\}", apiInvoker.escapeString(date.toString()));

    // query params
    List<Pair> queryParams = new ArrayList<Pair>();
    // header params
    Map<String, String> headerParams = new HashMap<String, String>();
    // form params
    Map<String, String> formParams = new HashMap<String, String>();

    
    queryParams.addAll(ApiInvoker.parameterToPairs("", "apikey", apikey));
    

    

    String[] contentTypes = {
      
    };
    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if (contentType.startsWith("multipart/form-data")) {
      // file uploading
      MultipartEntityBuilder builder = MultipartEntityBuilder.create();
      

      HttpEntity httpEntity = builder.build();
      postBody = httpEntity;
    } else {
      // normal form params
      
    }

    try {
      String response = apiInvoker.invokeAPI(basePath, path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Price) ApiInvoker.deserialize(response, "", Price.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      throw ex;
    }
  }
  
}
