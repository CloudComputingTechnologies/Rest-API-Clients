
#include "SamiPrice.h"
#include <FLocales.h>

using namespace Tizen::Base;
using namespace Tizen::System;
using namespace Tizen::Base::Utility;
using namespace Tizen::Base::Collection;
using namespace Tizen::Web::Json;
using namespace Tizen::Locales;


namespace Swagger {

SamiPrice::SamiPrice() {
    init();
}

SamiPrice::~SamiPrice() {
    this->cleanup();
}

void
SamiPrice::init() {
    pDate = null;
    pTicker = null;
    pValue = null;
    
}

void
SamiPrice::cleanup() {
    if(pDate != null) {
        
        delete pDate;
        pDate = null;
    }
    if(pTicker != null) {
        
        delete pTicker;
        pTicker = null;
    }
    if(pValue != null) {
        
        delete pValue;
        pValue = null;
    }
    
}


SamiPrice*
SamiPrice::fromJson(String* json) {
    this->cleanup();
    String str(json->GetPointer());
    int length = str.GetLength();

    ByteBuffer buffer;
    buffer.Construct(length);

    for (int i = 0; i < length; ++i) {
       byte b = str[i];
       buffer.SetByte(b);
    }

    IJsonValue* pJson = JsonParser::ParseN(buffer);
    fromJsonObject(pJson);
    if (pJson->GetType() == JSON_TYPE_OBJECT) {
       JsonObject* pObject = static_cast< JsonObject* >(pJson);
       pObject->RemoveAll(true);
    }
    else if (pJson->GetType() == JSON_TYPE_ARRAY) {
       JsonArray* pArray = static_cast< JsonArray* >(pJson);
       pArray->RemoveAll(true);
    }
    delete pJson;
    return this;
}


void
SamiPrice::fromJsonObject(IJsonValue* pJson) {
    JsonObject* pJsonObject = static_cast< JsonObject* >(pJson);

    if(pJsonObject != null) {
        JsonString* pDateKey = new JsonString(L"Date");
        IJsonValue* pDateVal = null;
        pJsonObject->GetValue(pDateKey, pDateVal);
        if(pDateVal != null) {
            
            pDate = new DateTime();
            jsonToValue(pDate, pDateVal, L"DateTime", L"DateTime");
        }
        delete pDateKey;
        JsonString* pTickerKey = new JsonString(L"Ticker");
        IJsonValue* pTickerVal = null;
        pJsonObject->GetValue(pTickerKey, pTickerVal);
        if(pTickerVal != null) {
            
            pTicker = new String();
            jsonToValue(pTicker, pTickerVal, L"String", L"String");
        }
        delete pTickerKey;
        JsonString* pValueKey = new JsonString(L"Value");
        IJsonValue* pValueVal = null;
        pJsonObject->GetValue(pValueKey, pValueVal);
        if(pValueVal != null) {
            
            pValue = new Double();
            jsonToValue(pValue, pValueVal, L"Double", L"Double");
        }
        delete pValueKey;
        
    }
}

SamiPrice::SamiPrice(String* json) {
    init();
    String str(json->GetPointer());
    int length = str.GetLength();

    ByteBuffer buffer;
    buffer.Construct(length);

    for (int i = 0; i < length; ++i) {
       byte b = str[i];
       buffer.SetByte(b);
    }

    IJsonValue* pJson = JsonParser::ParseN(buffer);
    fromJsonObject(pJson);
    if (pJson->GetType() == JSON_TYPE_OBJECT) {
       JsonObject* pObject = static_cast< JsonObject* >(pJson);
       pObject->RemoveAll(true);
    }
    else if (pJson->GetType() == JSON_TYPE_ARRAY) {
       JsonArray* pArray = static_cast< JsonArray* >(pJson);
       pArray->RemoveAll(true);
    }
    delete pJson;
}

String
SamiPrice::asJson ()
{
    JsonObject* pJsonObject = asJsonObject();

    char *pComposeBuf = new char[256];
    JsonWriter::Compose(pJsonObject, pComposeBuf, 256);
    String s = String(pComposeBuf);

    delete pComposeBuf;
    pJsonObject->RemoveAll(true);
    delete pJsonObject;

    return s;
}

JsonObject*
SamiPrice::asJsonObject() {
    JsonObject *pJsonObject = new JsonObject();
    pJsonObject->Construct();

    
    JsonString *pDateKey = new JsonString(L"Date");
    pJsonObject->Add(pDateKey, toJson(getPDate(), "DateTime", ""));

    
    JsonString *pTickerKey = new JsonString(L"Ticker");
    pJsonObject->Add(pTickerKey, toJson(getPTicker(), "String", ""));

    
    JsonString *pValueKey = new JsonString(L"Value");
    pJsonObject->Add(pValueKey, toJson(getPValue(), "Double", ""));

    
    return pJsonObject;
}

DateTime*
SamiPrice::getPDate() {
    return pDate;
}
void
SamiPrice::setPDate(DateTime* pDate) {
    this->pDate = pDate;
}

String*
SamiPrice::getPTicker() {
    return pTicker;
}
void
SamiPrice::setPTicker(String* pTicker) {
    this->pTicker = pTicker;
}

Double*
SamiPrice::getPValue() {
    return pValue;
}
void
SamiPrice::setPValue(Double* pValue) {
    this->pValue = pValue;
}



} /* namespace Swagger */

