using System;
using System.IO;
using System.Collections.Generic;
using System.Linq;
using RestSharp;
using IO.Swagger.Client;
using IO.Swagger.Model;

namespace IO.Swagger.Api
{
    
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public interface IPriceApi
    {
        
        /// <summary>
        /// 
        /// </summary>
        /// <remarks>
        /// 
        /// </remarks>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <returns>List&lt;Price&gt;</returns>
        List<Price> PriceGetByTicker (string apikey, string ticker);
  
        /// <summary>
        /// 
        /// </summary>
        /// <remarks>
        /// 
        /// </remarks>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <returns>ApiResponse of List&lt;Price&gt;</returns>
        ApiResponse<List<Price>> PriceGetByTickerWithHttpInfo (string apikey, string ticker);

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>
        /// 
        /// </remarks>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <returns>Task of List&lt;Price&gt;</returns>
        System.Threading.Tasks.Task<List<Price>> PriceGetByTickerAsync (string apikey, string ticker);

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>
        /// 
        /// </remarks>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <returns>Task of ApiResponse (List&lt;Price&gt;)</returns>
        System.Threading.Tasks.Task<ApiResponse<List<Price>>> PriceGetByTickerAsyncWithHttpInfo (string apikey, string ticker);
        
        /// <summary>
        /// 
        /// </summary>
        /// <remarks>
        /// 
        /// </remarks>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <param name="date"></param>
        /// <returns>Price</returns>
        Price PriceGet (string apikey, string ticker, DateTime? date);
  
        /// <summary>
        /// 
        /// </summary>
        /// <remarks>
        /// 
        /// </remarks>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <param name="date"></param>
        /// <returns>ApiResponse of Price</returns>
        ApiResponse<Price> PriceGetWithHttpInfo (string apikey, string ticker, DateTime? date);

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>
        /// 
        /// </remarks>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <param name="date"></param>
        /// <returns>Task of Price</returns>
        System.Threading.Tasks.Task<Price> PriceGetAsync (string apikey, string ticker, DateTime? date);

        /// <summary>
        /// 
        /// </summary>
        /// <remarks>
        /// 
        /// </remarks>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <param name="date"></param>
        /// <returns>Task of ApiResponse (Price)</returns>
        System.Threading.Tasks.Task<ApiResponse<Price>> PriceGetAsyncWithHttpInfo (string apikey, string ticker, DateTime? date);
        
    }
  
    /// <summary>
    /// Represents a collection of functions to interact with the API endpoints
    /// </summary>
    public class PriceApi : IPriceApi
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="PriceApi"/> class.
        /// </summary>
        /// <returns></returns>
        public PriceApi(String basePath)
        {
            this.Configuration = new Configuration(new ApiClient(basePath));
        }
    
        /// <summary>
        /// Initializes a new instance of the <see cref="PriceApi"/> class
        /// using Configuration object
        /// </summary>
        /// <param name="configuration">An instance of Configuration</param>
        /// <returns></returns>
        public PriceApi(Configuration configuration = null)
        {
            if (configuration == null) // use the default one in Configuration
                this.Configuration = Configuration.Default; 
            else
                this.Configuration = configuration;
        }

        /// <summary>
        /// Gets the base path of the API client.
        /// </summary>
        /// <value>The base path</value>
        public String GetBasePath()
        {
            return this.Configuration.ApiClient.RestClient.BaseUrl.ToString();
        }

        /// <summary>
        /// Sets the base path of the API client.
        /// </summary>
        /// <value>The base path</value>
        [Obsolete("SetBasePath is deprecated, please do 'Configuraiton.ApiClient = new ApiClient(\"http://new-path\")' instead.")]
        public void SetBasePath(String basePath)
        {
            // do nothing
        }
    
        /// <summary>
        /// Gets or sets the configuration object
        /// </summary>
        /// <value>An instance of the Configuration</value>
        public Configuration Configuration {get; set;}

        /// <summary>
        /// Gets the default header.
        /// </summary>
        /// <returns>Dictionary of HTTP header</returns>
        [Obsolete("DefaultHeader is deprecated, please use Configuration.DefaultHeader instead.")]
        public Dictionary<String, String> DefaultHeader()
        {
            return this.Configuration.DefaultHeader;
        }

        /// <summary>
        /// Add default header.
        /// </summary>
        /// <param name="key">Header field name.</param>
        /// <param name="value">Header field value.</param>
        /// <returns></returns>
        [Obsolete("AddDefaultHeader is deprecated, please use Configuration.AddDefaultHeader instead.")]
        public void AddDefaultHeader(string key, string value)
        {
            this.Configuration.AddDefaultHeader(key, value);
        }
   
        
        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param> 
        /// <param name="ticker"></param> 
        /// <returns>List&lt;Price&gt;</returns>
        public List<Price> PriceGetByTicker (string apikey, string ticker)
        {
             ApiResponse<List<Price>> response = PriceGetByTickerWithHttpInfo(apikey, ticker);
             return response.Data;
        }

        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param> 
        /// <param name="ticker"></param> 
        /// <returns>ApiResponse of List&lt;Price&gt;</returns>
        public ApiResponse< List<Price> > PriceGetByTickerWithHttpInfo (string apikey, string ticker)
        {
            
            // verify the required parameter 'apikey' is set
            if (apikey == null) throw new ApiException(400, "Missing required parameter 'apikey' when calling PriceGetByTicker");
            
            // verify the required parameter 'ticker' is set
            if (ticker == null) throw new ApiException(400, "Missing required parameter 'ticker' when calling PriceGetByTicker");
            
    
            var path_ = "/Price/{ticker}";
    
            var pathParams = new Dictionary<String, String>();
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>(Configuration.DefaultHeader);
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;

            // to determine the Accept header
            String[] http_header_accepts = new String[] {
                "application/json", "text/json", "application/xml", "text/xml"
            };
            String http_header_accept = Configuration.ApiClient.SelectHeaderAccept(http_header_accepts);
            if (http_header_accept != null)
                headerParams.Add("Accept", Configuration.ApiClient.SelectHeaderAccept(http_header_accepts));

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            pathParams.Add("format", "json");
            if (ticker != null) pathParams.Add("ticker", Configuration.ApiClient.ParameterToString(ticker)); // path parameter
            
            if (apikey != null) queryParams.Add("apikey", Configuration.ApiClient.ParameterToString(apikey)); // query parameter
            
            
            
            

            
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) Configuration.ApiClient.CallApi(path_, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, pathParams);

            int statusCode = (int) response.StatusCode;
    
            if (statusCode >= 400)
                throw new ApiException (statusCode, "Error calling PriceGetByTicker: " + response.Content, response.Content);
            else if (statusCode == 0)
                throw new ApiException (statusCode, "Error calling PriceGetByTicker: " + response.ErrorMessage, response.ErrorMessage);
    
            return new ApiResponse<List<Price>>(statusCode,
                response.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                (List<Price>) Configuration.ApiClient.Deserialize(response, typeof(List<Price>)));
            
        }
    
        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <returns>Task of List&lt;Price&gt;</returns>
        public async System.Threading.Tasks.Task<List<Price>> PriceGetByTickerAsync (string apikey, string ticker)
        {
             ApiResponse<List<Price>> response = await PriceGetByTickerAsyncWithHttpInfo(apikey, ticker);
             return response.Data;

        }

        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <returns>Task of ApiResponse (List&lt;Price&gt;)</returns>
        public async System.Threading.Tasks.Task<ApiResponse<List<Price>>> PriceGetByTickerAsyncWithHttpInfo (string apikey, string ticker)
        {
            // verify the required parameter 'apikey' is set
            if (apikey == null) throw new ApiException(400, "Missing required parameter 'apikey' when calling PriceGetByTicker");
            // verify the required parameter 'ticker' is set
            if (ticker == null) throw new ApiException(400, "Missing required parameter 'ticker' when calling PriceGetByTicker");
            
    
            var path_ = "/Price/{ticker}";
    
            var pathParams = new Dictionary<String, String>();
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;

            // to determine the Accept header
            String[] http_header_accepts = new String[] {
                "application/json", "text/json", "application/xml", "text/xml"
            };
            String http_header_accept = Configuration.ApiClient.SelectHeaderAccept(http_header_accepts);
            if (http_header_accept != null)
                headerParams.Add("Accept", Configuration.ApiClient.SelectHeaderAccept(http_header_accepts));

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            pathParams.Add("format", "json");
            if (ticker != null) pathParams.Add("ticker", Configuration.ApiClient.ParameterToString(ticker)); // path parameter
            
            if (apikey != null) queryParams.Add("apikey", Configuration.ApiClient.ParameterToString(apikey)); // query parameter
            
            
            
            

            

            // make the HTTP request
            IRestResponse response = (IRestResponse) await Configuration.ApiClient.CallApiAsync(path_, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, pathParams);

            int statusCode = (int) response.StatusCode;
 
            if (statusCode >= 400)
                throw new ApiException (statusCode, "Error calling PriceGetByTicker: " + response.Content, response.Content);
            else if (statusCode == 0)
                throw new ApiException (statusCode, "Error calling PriceGetByTicker: " + response.ErrorMessage, response.ErrorMessage);

            return new ApiResponse<List<Price>>(statusCode,
                response.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                (List<Price>) Configuration.ApiClient.Deserialize(response, typeof(List<Price>)));
            
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
             ApiResponse<Price> response = PriceGetWithHttpInfo(apikey, ticker, date);
             return response.Data;
        }

        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param> 
        /// <param name="ticker"></param> 
        /// <param name="date"></param> 
        /// <returns>ApiResponse of Price</returns>
        public ApiResponse< Price > PriceGetWithHttpInfo (string apikey, string ticker, DateTime? date)
        {
            
            // verify the required parameter 'apikey' is set
            if (apikey == null) throw new ApiException(400, "Missing required parameter 'apikey' when calling PriceGet");
            
            // verify the required parameter 'ticker' is set
            if (ticker == null) throw new ApiException(400, "Missing required parameter 'ticker' when calling PriceGet");
            
            // verify the required parameter 'date' is set
            if (date == null) throw new ApiException(400, "Missing required parameter 'date' when calling PriceGet");
            
    
            var path_ = "/Price/{ticker}/{date}";
    
            var pathParams = new Dictionary<String, String>();
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>(Configuration.DefaultHeader);
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;

            // to determine the Accept header
            String[] http_header_accepts = new String[] {
                "application/json", "text/json", "application/xml", "text/xml"
            };
            String http_header_accept = Configuration.ApiClient.SelectHeaderAccept(http_header_accepts);
            if (http_header_accept != null)
                headerParams.Add("Accept", Configuration.ApiClient.SelectHeaderAccept(http_header_accepts));

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            pathParams.Add("format", "json");
            if (ticker != null) pathParams.Add("ticker", Configuration.ApiClient.ParameterToString(ticker)); // path parameter
            if (date != null) pathParams.Add("date", Configuration.ApiClient.ParameterToString(date)); // path parameter
            
            if (apikey != null) queryParams.Add("apikey", Configuration.ApiClient.ParameterToString(apikey)); // query parameter
            
            
            
            

            
    
            // make the HTTP request
            IRestResponse response = (IRestResponse) Configuration.ApiClient.CallApi(path_, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, pathParams);

            int statusCode = (int) response.StatusCode;
    
            if (statusCode >= 400)
                throw new ApiException (statusCode, "Error calling PriceGet: " + response.Content, response.Content);
            else if (statusCode == 0)
                throw new ApiException (statusCode, "Error calling PriceGet: " + response.ErrorMessage, response.ErrorMessage);
    
            return new ApiResponse<Price>(statusCode,
                response.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                (Price) Configuration.ApiClient.Deserialize(response, typeof(Price)));
            
        }
    
        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <param name="date"></param>
        /// <returns>Task of Price</returns>
        public async System.Threading.Tasks.Task<Price> PriceGetAsync (string apikey, string ticker, DateTime? date)
        {
             ApiResponse<Price> response = await PriceGetAsyncWithHttpInfo(apikey, ticker, date);
             return response.Data;

        }

        /// <summary>
        ///  
        /// </summary>
        /// <param name="apikey"></param>
        /// <param name="ticker"></param>
        /// <param name="date"></param>
        /// <returns>Task of ApiResponse (Price)</returns>
        public async System.Threading.Tasks.Task<ApiResponse<Price>> PriceGetAsyncWithHttpInfo (string apikey, string ticker, DateTime? date)
        {
            // verify the required parameter 'apikey' is set
            if (apikey == null) throw new ApiException(400, "Missing required parameter 'apikey' when calling PriceGet");
            // verify the required parameter 'ticker' is set
            if (ticker == null) throw new ApiException(400, "Missing required parameter 'ticker' when calling PriceGet");
            // verify the required parameter 'date' is set
            if (date == null) throw new ApiException(400, "Missing required parameter 'date' when calling PriceGet");
            
    
            var path_ = "/Price/{ticker}/{date}";
    
            var pathParams = new Dictionary<String, String>();
            var queryParams = new Dictionary<String, String>();
            var headerParams = new Dictionary<String, String>();
            var formParams = new Dictionary<String, String>();
            var fileParams = new Dictionary<String, FileParameter>();
            String postBody = null;

            // to determine the Accept header
            String[] http_header_accepts = new String[] {
                "application/json", "text/json", "application/xml", "text/xml"
            };
            String http_header_accept = Configuration.ApiClient.SelectHeaderAccept(http_header_accepts);
            if (http_header_accept != null)
                headerParams.Add("Accept", Configuration.ApiClient.SelectHeaderAccept(http_header_accepts));

            // set "format" to json by default
            // e.g. /pet/{petId}.{format} becomes /pet/{petId}.json
            pathParams.Add("format", "json");
            if (ticker != null) pathParams.Add("ticker", Configuration.ApiClient.ParameterToString(ticker)); // path parameter
            if (date != null) pathParams.Add("date", Configuration.ApiClient.ParameterToString(date)); // path parameter
            
            if (apikey != null) queryParams.Add("apikey", Configuration.ApiClient.ParameterToString(apikey)); // query parameter
            
            
            
            

            

            // make the HTTP request
            IRestResponse response = (IRestResponse) await Configuration.ApiClient.CallApiAsync(path_, Method.GET, queryParams, postBody, headerParams, formParams, fileParams, pathParams);

            int statusCode = (int) response.StatusCode;
 
            if (statusCode >= 400)
                throw new ApiException (statusCode, "Error calling PriceGet: " + response.Content, response.Content);
            else if (statusCode == 0)
                throw new ApiException (statusCode, "Error calling PriceGet: " + response.ErrorMessage, response.ErrorMessage);

            return new ApiResponse<Price>(statusCode,
                response.Headers.ToDictionary(x => x.Name, x => x.Value.ToString()),
                (Price) Configuration.ApiClient.Deserialize(response, typeof(Price)));
            
        }
        
    }
    
}
