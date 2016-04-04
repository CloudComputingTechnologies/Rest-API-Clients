using System;
using System.IO;
using System.Collections.Generic;
using RestSharp;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace IO.Swagger.Api
{
    
    public interface IPriceApi
    {
        
        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <returns>List<Price></returns>
        List<Price> PriceGetByTicker (string apikey, string ticker);
        
        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <param name="date"></param>
        /// <returns>Price</returns>
        Price PriceGet (string apikey, string ticker, DateTime? date);
        
    }
  
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public class PriceApi : IPriceApi
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="PriceApi"/> class.
        /// </summary>
        /// <param name="apiClient"> an instance of ApiClient (optional)</param>
        /// <returns></returns>
        public PriceApi(ApiClient apiClient = null)
        {
            if (apiClient == null) // use the default one in Configuration
                this.ApiClient = Configuration.DefaultApiClient; 
            else
                this.ApiClient = apiClient;
        }
    
        /// <summary>
        /// Initializes a new instance of the <see cref="PriceApi"/> class.
        /// </summary>
        /// <returns></returns>
        public PriceApi(String basePath)
        {
            this.ApiClient = new ApiClient(basePath);
        }
    
        /// <summary>
        /// Sets the base path of the API client.
        /// </summary>
        /// <param name="basePath">The base path</param>
        /// <value>The base path</value>
        public void SetBasePath(String basePath)
        {
            this.ApiClient.BasePath = basePath;
        }
    
        /// <summary>
        /// Gets the base path of the API client.
        /// </summary>
        /// <param name="basePath">The base path</param>
        /// <value>The base path</value>
        public String GetBasePath(String basePath)
        {
            return this.ApiClient.BasePath;
        }
    
        /// <summary>
        /// Gets or sets the API client.
        /// </summary>
        /// <value>An instance of the ApiClient</param>
        public ApiClient ApiClient {get; set;}
    
        
        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param> 
        /// <param name="ticker"></param> 
        /// <returns>List<Price></returns>            
        public List<Price> PriceGetByTicker (string apikey, string ticker)
        {
            
            // verify the required parameter 'apikey' is set
            if (apikey == null) throw new ApiException(400, "Missing required parameter 'apikey' when calling PriceGetByTicker");
            
            // verify the required parameter 'ticker' is set
            if (ticker == null) throw new ApiException(400, "Missing required parameter 'ticker' when calling PriceGetByTicker");
            
    
            var path = "/Price/{ticker}";
            path = path.Replace("{format}", "json");
            path = path.Replace("{" + "ticker" + "}", ApiClient.ParameterToString(ticker));
            
    
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
             if (apikey != null) queryParams.Add("apikey", ApiClient.ParameterToString(apikey)); // query parameter
            
            
            
            
    
            // authentication setting, if any
            String[] authSettings = new String[] {  };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling PriceGetByTicker: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling PriceGetByTicker: " + response.ErrorMessage, response.ErrorMessage);
    
            return (List<Price>) ApiClient.Deserialize(response.Content, typeof(List<Price>), response.Headers);
        }
    
        
        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param> 
        /// <param name="ticker"></param> 
        /// <param name="date"></param> 
        /// <returns>Price</returns>            
        public Price PriceGet (string apikey, string ticker, DateTime? date)
        {
            
            // verify the required parameter 'apikey' is set
            if (apikey == null) throw new ApiException(400, "Missing required parameter 'apikey' when calling PriceGet");
            
            // verify the required parameter 'ticker' is set
            if (ticker == null) throw new ApiException(400, "Missing required parameter 'ticker' when calling PriceGet");
            
            // verify the required parameter 'date' is set
            if (date == null) throw new ApiException(400, "Missing required parameter 'date' when calling PriceGet");
            
    
            var path = "/Price/{ticker}/{date}";
            path = path.Replace("{format}", "json");
            path = path.Replace("{" + "ticker" + "}", ApiClient.ParameterToString(ticker));
            path = path.Replace("{" + "date" + "}", ApiClient.ParameterToString(date));
            
    
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;
    
             if (apikey != null) queryParams.Add("apikey", ApiClient.ParameterToString(apikey)); // query parameter
            
            
            
            
    
            // authentication setting, if any
            String[] authSettings = new String[] {  };
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) ApiClient.CallApi(path, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, authSettings);
    
            if (((int)response.StatusCode) >= 400)
                throw new ApiException ((int)response.StatusCode, "Error calling PriceGet: " + response.Content, response.Content);
            else if (((int)response.StatusCode) == 0)
                throw new ApiException ((int)response.StatusCode, "Error calling PriceGet: " + response.ErrorMessage, response.ErrorMessage);
    
            return (Price) ApiClient.Deserialize(response.Content, typeof(Price), response.Headers);
        }
    
        
    }
    
}
