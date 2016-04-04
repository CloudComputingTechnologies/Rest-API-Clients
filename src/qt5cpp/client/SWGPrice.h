/*
 * SWGPrice.h
 * 
 * 
 */

#ifndef SWGPrice_H_
#define SWGPrice_H_

#include <QJsonObject>


#include "QDateTime.h"
#include <QString>

#include "SWGObject.h"


namespace Swagger {

class SWGPrice: public SWGObject {
public:
    SWGPrice();
    SWGPrice(QString* json);
    virtual ~SWGPrice();
    void init();
    void cleanup();

    QString asJson ();
    QJsonObject* asJsonObject();
    void fromJsonObject(QJsonObject &json);
    SWGPrice* fromJson(QString &jsonString);

    QDateTime* getDate();
    void setDate(QDateTime* Date);
    QString* getTicker();
    void setTicker(QString* Ticker);
    double getValue();
    void setValue(double Value);
    

private:
    QDateTime* Date;
    QString* Ticker;
    double Value;
    
};

} /* namespace Swagger */

#endif /* SWGPrice_H_ */
