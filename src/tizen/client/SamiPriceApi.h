#ifndef SamiPriceApi_H_
#define SamiPriceApi_H_

#include <FNet.h>
#include "SamiApiClient.h"
#include "SamiError.h"

using Tizen::Base::String;
#include "SamiPrice.h"
using Tizen::Base::DateTime;

using namespace Tizen::Net::Http;

namespace Swagger {

class SamiPriceApi {
public:
  SamiPriceApi();
  virtual ~SamiPriceApi();

  
  IList* 
  priceGetByTickerWithCompletion(String* apikey, String* ticker, void (* handler)(IList*, SamiError*));
  
  SamiPrice* 
  priceGetWithCompletion(String* apikey, String* ticker, DateTime* date, void (* handler)(SamiPrice*, SamiError*));
  
  static String getBasePath() {
    return L"http://localhost:15534";
  }

private:
  SamiApiClient* client;
};


} /* namespace Swagger */

#endif /* SamiPriceApi_H_ */
