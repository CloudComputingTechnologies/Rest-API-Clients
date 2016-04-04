#ifndef _SWG_SWGPriceApi_H_
#define _SWG_SWGPriceApi_H_

#include "SWGHttpRequest.h"

#include <QString>
#include "SWGPrice.h"
#include "QDateTime.h"

#include <QObject>

namespace Swagger {

class SWGPriceApi: public QObject {
    Q_OBJECT

public:
    SWGPriceApi();
    SWGPriceApi(QString host, QString basePath);
    ~SWGPriceApi();

    QString host;
    QString basePath;

    void priceGetByTicker(QString* apikey, QString* ticker);
    void priceGet(QString* apikey, QString* ticker, QDateTime* date);
    
private:
    void priceGetByTickerCallback (HttpRequestWorker * worker);
    void priceGetCallback (HttpRequestWorker * worker);
    
signals:
    void priceGetByTickerSignal(QList<SWGPrice*>* summary);
    void priceGetSignal(SWGPrice* summary);
    
};
}
#endif