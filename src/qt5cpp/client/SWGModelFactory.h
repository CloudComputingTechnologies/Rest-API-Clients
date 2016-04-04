#ifndef ModelFactory_H_
#define ModelFactory_H_


#include "SWGPrice.h"

namespace Swagger {
  inline void* create(QString type) {
    if(QString("SWGPrice").compare(type) == 0) {
      return new SWGPrice();
    }
    
    return NULL;
  }

  inline void* create(QString json, QString type) {
    void* val = create(type);
    if(val != NULL) {
      SWGObject* obj = static_cast<SWGObject*>(val);
      return obj->fromJson(json);
    }
    if(type.startsWith("QString")) {
      return new QString();
    }
    return NULL;
  }
} /* namespace Swagger */

#endif /* ModelFactory_H_ */
