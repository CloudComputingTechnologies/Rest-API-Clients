/*
 * SamiPrice.h
 * 
 * 
 */

#ifndef SamiPrice_H_
#define SamiPrice_H_

#include <FApp.h>
#include <FBase.h>
#include <FSystem.h>
#include <FWebJson.h>
#include "SamiHelpers.h"
#include "SamiObject.h"

using namespace Tizen::Web::Json;


using Tizen::Base::DateTime;
using Tizen::Base::Double;
using Tizen::Base::String;


namespace Swagger {

class SamiPrice: public SamiObject {
public:
    SamiPrice();
    SamiPrice(String* json);
    virtual ~SamiPrice();

    void init();

    void cleanup();

    String asJson ();

    JsonObject* asJsonObject();

    void fromJsonObject(IJsonValue* json);

    SamiPrice* fromJson(String* obj);

    
    DateTime* getPDate();
    void setPDate(DateTime* pDate);
    
    String* getPTicker();
    void setPTicker(String* pTicker);
    
    Double* getPValue();
    void setPValue(Double* pValue);
    

private:
    DateTime* pDate;
    String* pTicker;
    Double* pValue;
    
};

} /* namespace Swagger */

#endif /* SamiPrice_H_ */
