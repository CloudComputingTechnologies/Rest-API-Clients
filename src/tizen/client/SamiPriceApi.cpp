#include "SamiPriceApi.h"

#include "SamiHelpers.h"
#include "SamiError.h"

using namespace Tizen::Base;

namespace Swagger {


SamiPriceApi::SamiPriceApi() {

}

SamiPriceApi::~SamiPriceApi() {

}

void
priceGetByTickerProcessor(HttpResponse* pHttpResponse, void (* handler)(void*, SamiError*)) {
  int code = pHttpResponse->GetHttpStatusCode();

  if(code >= 200 && code < 300) {
    ByteBuffer* pBuffer = pHttpResponse->ReadBodyN();
    IJsonValue* pJson = JsonParser::ParseN(*pBuffer);

    IList* out = new ArrayList();
    jsonToValue(out, pJson, L"IList*", L"SamiPrice");

    if (pJson) {
      if (pJson->GetType() == JSON_TYPE_OBJECT) {
         JsonObject* pObject = static_cast< JsonObject* >(pJson);
         pObject->RemoveAll(true);
      }
      else if (pJson->GetType() == JSON_TYPE_ARRAY) {
         JsonArray* pArray = static_cast< JsonArray* >(pJson);
         pArray->RemoveAll(true);
      }
      handler(out, null);
    }
    else {
      SamiError* error = new SamiError(0, new String(L"No parsable response received"));
      handler(null, error);
    }
    
  }
  else {
    SamiError* error = new SamiError(code, new String(pHttpResponse->GetStatusText()));
    handler(null, error);
    
  }
}

IList* 
SamiPriceApi::priceGetByTickerWithCompletion(String* apikey, String* ticker, void (* success)(IList*, SamiError*)) {
  client = new SamiApiClient();

  client->success(&priceGetByTickerProcessor, (void(*)(void*, SamiError*))success);
  HashMap* headerParams = new HashMap(SingleObjectDeleter);
  headerParams->Construct();

  

  HashMap* queryParams = new HashMap(SingleObjectDeleter);
  queryParams->Construct();

  
    queryParams->Add(new String("apikey"), apikey);
  
  

  String* mBody = null;

  

  String url(L"/Price/{ticker}");

  
  String s_ticker(L"{");
  s_ticker.Append(L"ticker");
  s_ticker.Append(L"}");
  url.Replace(s_ticker, stringify(ticker, L"String*"));
  

  client->execute(SamiPriceApi::getBasePath(), url, "GET", (IMap*)queryParams, mBody, (IMap*)headerParams, null, L"application/json");
  return null;
}

void
priceGetProcessor(HttpResponse* pHttpResponse, void (* handler)(void*, SamiError*)) {
  int code = pHttpResponse->GetHttpStatusCode();

  if(code >= 200 && code < 300) {
    ByteBuffer* pBuffer = pHttpResponse->ReadBodyN();
    IJsonValue* pJson = JsonParser::ParseN(*pBuffer);

    SamiPrice* out = new SamiPrice();
    jsonToValue(out, pJson, L"SamiPrice*", L"SamiPrice");

    if (pJson) {
      if (pJson->GetType() == JSON_TYPE_OBJECT) {
         JsonObject* pObject = static_cast< JsonObject* >(pJson);
         pObject->RemoveAll(true);
      }
      else if (pJson->GetType() == JSON_TYPE_ARRAY) {
         JsonArray* pArray = static_cast< JsonArray* >(pJson);
         pArray->RemoveAll(true);
      }
      handler(out, null);
    }
    else {
      SamiError* error = new SamiError(0, new String(L"No parsable response received"));
      handler(null, error);
    }
    
  }
  else {
    SamiError* error = new SamiError(code, new String(pHttpResponse->GetStatusText()));
    handler(null, error);
    
  }
}

SamiPrice* 
SamiPriceApi::priceGetWithCompletion(String* apikey, String* ticker, DateTime* date, void (* success)(SamiPrice*, SamiError*)) {
  client = new SamiApiClient();

  client->success(&priceGetProcessor, (void(*)(void*, SamiError*))success);
  HashMap* headerParams = new HashMap(SingleObjectDeleter);
  headerParams->Construct();

  

  HashMap* queryParams = new HashMap(SingleObjectDeleter);
  queryParams->Construct();

  
    queryParams->Add(new String("apikey"), apikey);
  
  

  String* mBody = null;

  

  String url(L"/Price/{ticker}/{date}");

  
  String s_ticker(L"{");
  s_ticker.Append(L"ticker");
  s_ticker.Append(L"}");
  url.Replace(s_ticker, stringify(ticker, L"String*"));
  
  String s_date(L"{");
  s_date.Append(L"date");
  s_date.Append(L"}");
  url.Replace(s_date, stringify(date, L"DateTime*"));
  

  client->execute(SamiPriceApi::getBasePath(), url, "GET", (IMap*)queryParams, mBody, (IMap*)headerParams, null, L"application/json");
  return null;
}


} /* namespace Swagger */
