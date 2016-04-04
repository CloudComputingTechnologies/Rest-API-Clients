require 'json'


MyApp.add_route('GET', '/Price/{ticker}', {
  "resourcePath" => "/Price",
  "summary" => "",
  "nickname" => "price_get_by_ticker", 
  "responseClass" => "array[Price]", 
  "endpoint" => "/Price/{ticker}", 
  "notes" => "",
  "parameters" => [
    
    {
      "name" => "apikey",
      "description" => "",
      "dataType" => "string",
      "paramType" => "query",
      
      "allowableValues" => "",
      
    },
    
    
    {
      "name" => "ticker",
      "description" => "",
      "dataType" => "string",
      "paramType" => "path",
    },
    
    
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end


MyApp.add_route('GET', '/Price/{ticker}/{date}', {
  "resourcePath" => "/Price",
  "summary" => "",
  "nickname" => "price_get", 
  "responseClass" => "Price", 
  "endpoint" => "/Price/{ticker}/{date}", 
  "notes" => "",
  "parameters" => [
    
    {
      "name" => "apikey",
      "description" => "",
      "dataType" => "string",
      "paramType" => "query",
      
      "allowableValues" => "",
      
    },
    
    
    {
      "name" => "ticker",
      "description" => "",
      "dataType" => "string",
      "paramType" => "path",
    },
    
    {
      "name" => "date",
      "description" => "",
      "dataType" => "DateTime",
      "paramType" => "path",
    },
    
    
    
    ]}) do
  cross_origin
  # the guts live here

  {"message" => "yes, it worked"}.to_json
end

