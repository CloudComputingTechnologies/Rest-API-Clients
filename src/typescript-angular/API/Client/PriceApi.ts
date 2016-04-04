/// <reference path="api.d.ts" />

/* tslint:disable:no-unused-variable member-ordering */

namespace API.Client {
    'use strict';

    export class PriceApi {
        protected basePath = 'http://localhost:15534';
        public defaultHeaders : any = {};

        static $inject: string[] = ['$http', '$httpParamSerializer'];

        constructor(protected $http: ng.IHttpService, protected $httpParamSerializer?: (d: any) => any, basePath?: string) {
            if (basePath) {
                this.basePath = basePath;
            }
        }

        private extendObj<T1,T2>(objA: T1, objB: T2) {
            for(let key in objB){
                if(objB.hasOwnProperty(key)){
                    objA[key] = objB[key];
                }
            }
            return <T1&T2>objA;
        }

        /**
         * 
         * 
         * @param apikey 
         * @param ticker 
         */
        public priceGetByTicker (apikey: string, ticker: string, extraHttpRequestParams?: any ) : ng.IHttpPromise<Array<Price>> {
            const path = this.basePath + '/Price/{ticker}'
                .replace('{' + 'ticker' + '}', String(ticker));

            let queryParameters: any = {};
            let headerParams: any = this.extendObj({}, this.defaultHeaders);
            // verify required parameter 'apikey' is set
            if (!apikey) {
                throw new Error('Missing required parameter apikey when calling priceGetByTicker');
            }
            // verify required parameter 'ticker' is set
            if (!ticker) {
                throw new Error('Missing required parameter ticker when calling priceGetByTicker');
            }
            if (apikey !== undefined) {
                queryParameters['apikey'] = apikey;
            }

            let httpRequestParams: any = {
                method: 'GET',
                url: path,
                json: true,
                
                
                params: queryParameters,
                headers: headerParams
            };

            if (extraHttpRequestParams) {
                httpRequestParams = this.extendObj(httpRequestParams, extraHttpRequestParams);
            }

            return this.$http(httpRequestParams);
        }
        /**
         * 
         * 
         * @param apikey 
         * @param ticker 
         * @param date 
         */
        public priceGet (apikey: string, ticker: string, date: Date, extraHttpRequestParams?: any ) : ng.IHttpPromise<Price> {
            const path = this.basePath + '/Price/{ticker}/{date}'
                .replace('{' + 'ticker' + '}', String(ticker))
                .replace('{' + 'date' + '}', String(date));

            let queryParameters: any = {};
            let headerParams: any = this.extendObj({}, this.defaultHeaders);
            // verify required parameter 'apikey' is set
            if (!apikey) {
                throw new Error('Missing required parameter apikey when calling priceGet');
            }
            // verify required parameter 'ticker' is set
            if (!ticker) {
                throw new Error('Missing required parameter ticker when calling priceGet');
            }
            // verify required parameter 'date' is set
            if (!date) {
                throw new Error('Missing required parameter date when calling priceGet');
            }
            if (apikey !== undefined) {
                queryParameters['apikey'] = apikey;
            }

            let httpRequestParams: any = {
                method: 'GET',
                url: path,
                json: true,
                
                
                params: queryParameters,
                headers: headerParams
            };

            if (extraHttpRequestParams) {
                httpRequestParams = this.extendObj(httpRequestParams, extraHttpRequestParams);
            }

            return this.$http(httpRequestParams);
        }
    }
}
