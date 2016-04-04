part of api;


class PriceApi {
  String basePath = "http://localhost:15534";
  ApiClient apiClient = ApiClient.defaultApiClient;

  PriceApi([ApiClient apiClient]) {
    if (apiClient != null) {
      this.apiClient = apiClient;
    }
  }

  
  /// 
  ///
  /// 
  Future<List<Price>> priceGetByTicker(String apikey, String ticker) {
    Object postBody = null;
    

    // create path and map variables
    String path = "/Price/{ticker}".replaceAll("{format}","json").replaceAll("{" + "ticker" + "}", ticker.toString());

    // query params
    Map<String, String> queryParams = {};
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    if("null" != apikey)
      queryParams["apikey"] = apikey is List ? apikey.join(',') : apikey;
    
    

    List<String> contentTypes = [];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = [];

    if(contentType.startsWith("multipart/form-data")) {
      bool hasFields = false;
      MultipartRequest mp = new MultipartRequest(null, null);
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    return apiClient.invokeAPI(basePath, path, 'GET', queryParams, postBody, headerParams, formParams, contentType, authNames).then((response) {
      if(response.statusCode >= 400) {
        throw new ApiException(response.statusCode, response.body);
      }
      else if(response.body != null){
        return ApiClient.deserialize(response.body, Price);
      }
      else {
        return null;
      }
    });
  }
  
  /// 
  ///
  /// 
  Future<Price> priceGet(String apikey, String ticker, DateTime date) {
    Object postBody = null;
    

    // create path and map variables
    String path = "/Price/{ticker}/{date}".replaceAll("{format}","json").replaceAll("{" + "ticker" + "}", ticker.toString()).replaceAll("{" + "date" + "}", date.toString());

    // query params
    Map<String, String> queryParams = {};
    Map<String, String> headerParams = {};
    Map<String, String> formParams = {};
    if("null" != apikey)
      queryParams["apikey"] = apikey is List ? apikey.join(',') : apikey;
    
    

    List<String> contentTypes = [];

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";
    List<String> authNames = [];

    if(contentType.startsWith("multipart/form-data")) {
      bool hasFields = false;
      MultipartRequest mp = new MultipartRequest(null, null);
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    return apiClient.invokeAPI(basePath, path, 'GET', queryParams, postBody, headerParams, formParams, contentType, authNames).then((response) {
      if(response.statusCode >= 400) {
        throw new ApiException(response.statusCode, response.body);
      }
      else if(response.body != null){
        return ApiClient.deserialize(response.body, Price);
      }
      else {
        return null;
      }
    });
  }
  
}
