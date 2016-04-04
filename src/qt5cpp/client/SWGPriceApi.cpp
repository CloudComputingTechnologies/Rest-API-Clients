#include "SWGPriceApi.h"
#include "SWGHelpers.h"
#include "SWGModelFactory.h"

#include <QJsonArray>
#include <QJsonDocument>

namespace Swagger {
SWGPriceApi::SWGPriceApi() {}

SWGPriceApi::~SWGPriceApi() {}

SWGPriceApi::SWGPriceApi(QString host, QString basePath) {
    this->host = host;
    this->basePath = basePath;
}

void
SWGPriceApi::priceGetByTicker(QString* apikey, QString* ticker) {
    QString fullPath;
    fullPath.append(this->host).append(this->basePath).append("/Price/{ticker}");

    
    QString tickerPathParam("{"); tickerPathParam.append("ticker").append("}");
    fullPath.replace(tickerPathParam, stringValue(ticker));
    

    
    
    if(fullPath.indexOf("?") > 0) 
      fullPath.append("&");
    else 
      fullPath.append("?");
    fullPath.append(QUrl::toPercentEncoding("apikey"))
        .append("=")
        .append(QUrl::toPercentEncoding(stringValue(apikey)));
    

    
    

    HttpRequestWorker *worker = new HttpRequestWorker();
    HttpRequestInput input(fullPath, "GET");

    

    

    

    connect(worker,
            &HttpRequestWorker::on_execution_finished,
            this,
            &SWGPriceApi::priceGetByTickerCallback);

    worker->execute(&input);
}

void
SWGPriceApi::priceGetByTickerCallback(HttpRequestWorker * worker) {
    QString msg;
    if (worker->error_type == QNetworkReply::NoError) {
        msg = QString("Success! %1 bytes").arg(worker->response.length());
    }
    else {
        msg = "Error: " + worker->error_str;
    }

    
    QList<SWGPrice*>* output = new QList<SWGPrice*>();
    QString json(worker->response);
    QByteArray array (json.toStdString().c_str());
    QJsonDocument doc = QJsonDocument::fromJson(array);
    QJsonArray jsonArray = doc.array();

    foreach(QJsonValue obj, jsonArray) {
        SWGPrice* o = new SWGPrice();
        QJsonObject jv = obj.toObject();
        QJsonObject * ptr = (QJsonObject*)&jv;
        o->fromJsonObject(*ptr);
        output->append(o);
    }
    

    

    worker->deleteLater();

    emit priceGetByTickerSignal(output);
    
}
void
SWGPriceApi::priceGet(QString* apikey, QString* ticker, QDateTime* date) {
    QString fullPath;
    fullPath.append(this->host).append(this->basePath).append("/Price/{ticker}/{date}");

    
    QString tickerPathParam("{"); tickerPathParam.append("ticker").append("}");
    fullPath.replace(tickerPathParam, stringValue(ticker));
    
    QString datePathParam("{"); datePathParam.append("date").append("}");
    fullPath.replace(datePathParam, stringValue(date));
    

    
    
    if(fullPath.indexOf("?") > 0) 
      fullPath.append("&");
    else 
      fullPath.append("?");
    fullPath.append(QUrl::toPercentEncoding("apikey"))
        .append("=")
        .append(QUrl::toPercentEncoding(stringValue(apikey)));
    

    
    

    HttpRequestWorker *worker = new HttpRequestWorker();
    HttpRequestInput input(fullPath, "GET");

    

    

    

    connect(worker,
            &HttpRequestWorker::on_execution_finished,
            this,
            &SWGPriceApi::priceGetCallback);

    worker->execute(&input);
}

void
SWGPriceApi::priceGetCallback(HttpRequestWorker * worker) {
    QString msg;
    if (worker->error_type == QNetworkReply::NoError) {
        msg = QString("Success! %1 bytes").arg(worker->response.length());
    }
    else {
        msg = "Error: " + worker->error_str;
    }

    

    
    
    
    QString json(worker->response);
    SWGPrice* output = static_cast<SWGPrice*>(create(json, QString("SWGPrice")));
    
    
    

    worker->deleteLater();

    emit priceGetSignal(output);
    
}
} /* namespace Swagger */
