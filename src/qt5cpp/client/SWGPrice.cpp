
#include "SWGPrice.h"

#include "SWGHelpers.h"

#include <QJsonDocument>
#include <QJsonArray>
#include <QObject>
#include <QDebug>

namespace Swagger {


SWGPrice::SWGPrice(QString* json) {
    init();
    this->fromJson(*json);
}

SWGPrice::SWGPrice() {
    init();
}

SWGPrice::~SWGPrice() {
    this->cleanup();
}

void
SWGPrice::init() {
    Date = NULL;
    Ticker = new QString("");
    Value = 0.0;
    
}

void
SWGPrice::cleanup() {
    if(Date != NULL) {
        delete Date;
    }
    if(Ticker != NULL) {
        delete Ticker;
    }
    
    
}

SWGPrice*
SWGPrice::fromJson(QString &json) {
    QByteArray array (json.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonObject jsonObject = doc.object();
    this->fromJsonObject(jsonObject);
    return this;
}

void
SWGPrice::fromJsonObject(QJsonObject &pJson) {
    setValue(&Date, pJson["Date"], "QDateTime", "QDateTime");
    setValue(&Ticker, pJson["Ticker"], "QString", "QString");
    setValue(&Value, pJson["Value"], "double", "");
    
}

QString
SWGPrice::asJson ()
{
    QJsonObject* obj = this->asJsonObject();
    
    QJsonDocument doc(*obj);
    QByteArray bytes = doc.toJson();
    return QString(bytes);
}

QJsonObject*
SWGPrice::asJsonObject() {
    QJsonObject* obj = new QJsonObject();
    
    
    toJsonValue(QString("Date"), Date, obj, QString("QDateTime"));
    
    
    
    
    
    toJsonValue(QString("Ticker"), Ticker, obj, QString("QString"));
    
    
    
    obj->insert("Value", QJsonValue(Value));
    

    return obj;
}

QDateTime*
SWGPrice::getDate() {
    return Date;
}
void
SWGPrice::setDate(QDateTime* Date) {
    this->Date = Date;
}

QString*
SWGPrice::getTicker() {
    return Ticker;
}
void
SWGPrice::setTicker(QString* Ticker) {
    this->Ticker = Ticker;
}

double
SWGPrice::getValue() {
    return Value;
}
void
SWGPrice::setValue(double Value) {
    this->Value = Value;
}



} /* namespace Swagger */

