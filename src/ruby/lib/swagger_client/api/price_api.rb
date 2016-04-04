require "uri"

module SwaggerClient
  class PriceApi
    attr_accessor :api_client

    def initialize(api_client = ApiClient.default)
      @api_client = api_client
    end

    # 
    # 
    # @param apikey 
    # @param ticker 
    # @param [Hash] opts the optional parameters
    # @return [Array<Price>]
    def price_get_by_ticker(apikey, ticker, opts = {})
      data, status_code, headers = price_get_by_ticker_with_http_info(apikey, ticker, opts)
      return data
    end

    # 
    # 
    # @param apikey 
    # @param ticker 
    # @param [Hash] opts the optional parameters
    # @return [Array<(Array<Price>, Fixnum, Hash)>] Array<Price> data, response status code and response headers
    def price_get_by_ticker_with_http_info(apikey, ticker, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug "Calling API: PriceApi#price_get_by_ticker ..."
      end
      
      # verify the required parameter 'apikey' is set
      fail "Missing the required parameter 'apikey' when calling price_get_by_ticker" if apikey.nil?
      
      # verify the required parameter 'ticker' is set
      fail "Missing the required parameter 'ticker' when calling price_get_by_ticker" if ticker.nil?
      
      # resource path
      path = "/Price/{ticker}".sub('{format}','json').sub('{' + 'ticker' + '}', ticker.to_s)

      # query parameters
      query_params = {}
      query_params[:'apikey'] = apikey

      # header parameters
      header_params = {}

      # HTTP header 'Accept' (if needed)
      _header_accept = ['application/json', 'text/json', 'application/xml', 'text/xml']
      _header_accept_result = @api_client.select_header_accept(_header_accept) and header_params['Accept'] = _header_accept_result

      # HTTP header 'Content-Type'
      _header_content_type = []
      header_params['Content-Type'] = @api_client.select_header_content_type(_header_content_type)

      # form parameters
      form_params = {}

      # http body (model)
      post_body = nil
      

      auth_names = []
      data, status_code, headers = @api_client.call_api(:GET, path,
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => 'Array<Price>')
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: PriceApi#price_get_by_ticker\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end

    # 
    # 
    # @param apikey 
    # @param ticker 
    # @param date 
    # @param [Hash] opts the optional parameters
    # @return [Price]
    def price_get(apikey, ticker, date, opts = {})
      data, status_code, headers = price_get_with_http_info(apikey, ticker, date, opts)
      return data
    end

    # 
    # 
    # @param apikey 
    # @param ticker 
    # @param date 
    # @param [Hash] opts the optional parameters
    # @return [Array<(Price, Fixnum, Hash)>] Price data, response status code and response headers
    def price_get_with_http_info(apikey, ticker, date, opts = {})
      if @api_client.config.debugging
        @api_client.config.logger.debug "Calling API: PriceApi#price_get ..."
      end
      
      # verify the required parameter 'apikey' is set
      fail "Missing the required parameter 'apikey' when calling price_get" if apikey.nil?
      
      # verify the required parameter 'ticker' is set
      fail "Missing the required parameter 'ticker' when calling price_get" if ticker.nil?
      
      # verify the required parameter 'date' is set
      fail "Missing the required parameter 'date' when calling price_get" if date.nil?
      
      # resource path
      path = "/Price/{ticker}/{date}".sub('{format}','json').sub('{' + 'ticker' + '}', ticker.to_s).sub('{' + 'date' + '}', date.to_s)

      # query parameters
      query_params = {}
      query_params[:'apikey'] = apikey

      # header parameters
      header_params = {}

      # HTTP header 'Accept' (if needed)
      _header_accept = ['application/json', 'text/json', 'application/xml', 'text/xml']
      _header_accept_result = @api_client.select_header_accept(_header_accept) and header_params['Accept'] = _header_accept_result

      # HTTP header 'Content-Type'
      _header_content_type = []
      header_params['Content-Type'] = @api_client.select_header_content_type(_header_content_type)

      # form parameters
      form_params = {}

      # http body (model)
      post_body = nil
      

      auth_names = []
      data, status_code, headers = @api_client.call_api(:GET, path,
        :header_params => header_params,
        :query_params => query_params,
        :form_params => form_params,
        :body => post_body,
        :auth_names => auth_names,
        :return_type => 'Price')
      if @api_client.config.debugging
        @api_client.config.logger.debug "API called: PriceApi#price_get\nData: #{data.inspect}\nStatus code: #{status_code}\nHeaders: #{headers}"
      end
      return data, status_code, headers
    end
  end
end




