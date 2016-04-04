#import "SWGPriceApi.h"
#import "SWGQueryParamCollection.h"
#import "SWGPrice.h"


@interface SWGPriceApi ()
    @property (readwrite, nonatomic, strong) NSMutableDictionary *defaultHeaders;
@end

@implementation SWGPriceApi

static SWGPriceApi* singletonAPI = nil;

#pragma mark - Initialize methods

- (id) init {
    self = [super init];
    if (self) {
        SWGConfiguration *config = [SWGConfiguration sharedConfig];
        if (config.apiClient == nil) {
            config.apiClient = [[SWGApiClient alloc] init];
        }
        self.apiClient = config.apiClient;
        self.defaultHeaders = [NSMutableDictionary dictionary];
    }
    return self;
}

- (id) initWithApiClient:(SWGApiClient *)apiClient {
    self = [super init];
    if (self) {
        self.apiClient = apiClient;
        self.defaultHeaders = [NSMutableDictionary dictionary];
    }
    return self;
}

#pragma mark -

+(SWGPriceApi*) apiWithHeader:(NSString*)headerValue key:(NSString*)key {

    if (singletonAPI == nil) {
        singletonAPI = [[SWGPriceApi alloc] init];
        [singletonAPI addHeader:headerValue forKey:key];
    }
    return singletonAPI;
}

+(SWGPriceApi*) sharedAPI {

    if (singletonAPI == nil) {
        singletonAPI = [[SWGPriceApi alloc] init];
    }
    return singletonAPI;
}

-(void) addHeader:(NSString*)value forKey:(NSString*)key {
    [self.defaultHeaders setValue:value forKey:key];
}

-(void) setHeaderValue:(NSString*) value
           forKey:(NSString*)key {
    [self.defaultHeaders setValue:value forKey:key];
}

-(unsigned long) requestQueueSize {
    return [SWGApiClient requestQueueSize];
}

#pragma mark - Api Methods

///
/// 
/// 
///  @param apikey 
///
///  @param ticker 
///
///  @returns NSArray<SWGPrice>*
///
-(NSNumber*) priceGetByTickerWithCompletionBlock: (NSString*) apikey
         ticker: (NSString*) ticker
        
        completionHandler: (void (^)(NSArray<SWGPrice>* output, NSError* error))completionBlock { 
        

    
    // verify the required parameter 'apikey' is set
    if (apikey == nil) {
        [NSException raise:@"Invalid parameter" format:@"Missing the required parameter `apikey` when calling `priceGetByTicker`"];
    }
    
    // verify the required parameter 'ticker' is set
    if (ticker == nil) {
        [NSException raise:@"Invalid parameter" format:@"Missing the required parameter `ticker` when calling `priceGetByTicker`"];
    }
    

    NSMutableString* resourcePath = [NSMutableString stringWithFormat:@"/Price/{ticker}"];

    // remove format in URL if needed
    if ([resourcePath rangeOfString:@".{format}"].location != NSNotFound) {
        [resourcePath replaceCharactersInRange: [resourcePath rangeOfString:@".{format}"] withString:@".json"];
    }

    NSMutableDictionary *pathParams = [[NSMutableDictionary alloc] init];
    if (ticker != nil) {
        pathParams[@"ticker"] = ticker;
    }
    

    NSMutableDictionary* queryParams = [[NSMutableDictionary alloc] init];
    if (apikey != nil) {
        
        queryParams[@"apikey"] = apikey;
    }
    
    NSMutableDictionary* headerParams = [NSMutableDictionary dictionaryWithDictionary:self.defaultHeaders];

    

    // HTTP header `Accept`
    headerParams[@"Accept"] = [SWGApiClient selectHeaderAccept:@[@"application/json", @"text/json", @"application/xml", @"text/xml"]];
    if ([headerParams[@"Accept"] length] == 0) {
        [headerParams removeObjectForKey:@"Accept"];
    }

    // response content type
    NSString *responseContentType;
    if ([headerParams objectForKey:@"Accept"]) {
        responseContentType = [headerParams[@"Accept"] componentsSeparatedByString:@", "][0];
    }
    else {
        responseContentType = @"";
    }

    // request content type
    NSString *requestContentType = [SWGApiClient selectHeaderContentType:@[]];

    // Authentication setting
    NSArray *authSettings = @[];

    id bodyParam = nil;
    NSMutableDictionary *formParams = [[NSMutableDictionary alloc] init];
    NSMutableDictionary *files = [[NSMutableDictionary alloc] init];
    
    
    

    
    return [self.apiClient requestWithCompletionBlock: resourcePath
                                               method: @"GET"
                                           pathParams: pathParams
                                          queryParams: queryParams
                                           formParams: formParams
                                                files: files
                                                 body: bodyParam
                                         headerParams: headerParams
                                         authSettings: authSettings
                                   requestContentType: requestContentType
                                  responseContentType: responseContentType
                                         responseType: @"NSArray<SWGPrice>*"
                                      completionBlock: ^(id data, NSError *error) {
                  
                  completionBlock((NSArray<SWGPrice>*)data, error);
              }
          ];
}

///
/// 
/// 
///  @param apikey 
///
///  @param ticker 
///
///  @param date 
///
///  @returns SWGPrice*
///
-(NSNumber*) priceGetWithCompletionBlock: (NSString*) apikey
         ticker: (NSString*) ticker
         date: (NSDate*) date
        
        completionHandler: (void (^)(SWGPrice* output, NSError* error))completionBlock { 
        

    
    // verify the required parameter 'apikey' is set
    if (apikey == nil) {
        [NSException raise:@"Invalid parameter" format:@"Missing the required parameter `apikey` when calling `priceGet`"];
    }
    
    // verify the required parameter 'ticker' is set
    if (ticker == nil) {
        [NSException raise:@"Invalid parameter" format:@"Missing the required parameter `ticker` when calling `priceGet`"];
    }
    
    // verify the required parameter 'date' is set
    if (date == nil) {
        [NSException raise:@"Invalid parameter" format:@"Missing the required parameter `date` when calling `priceGet`"];
    }
    

    NSMutableString* resourcePath = [NSMutableString stringWithFormat:@"/Price/{ticker}/{date}"];

    // remove format in URL if needed
    if ([resourcePath rangeOfString:@".{format}"].location != NSNotFound) {
        [resourcePath replaceCharactersInRange: [resourcePath rangeOfString:@".{format}"] withString:@".json"];
    }

    NSMutableDictionary *pathParams = [[NSMutableDictionary alloc] init];
    if (ticker != nil) {
        pathParams[@"ticker"] = ticker;
    }
    if (date != nil) {
        pathParams[@"date"] = date;
    }
    

    NSMutableDictionary* queryParams = [[NSMutableDictionary alloc] init];
    if (apikey != nil) {
        
        queryParams[@"apikey"] = apikey;
    }
    
    NSMutableDictionary* headerParams = [NSMutableDictionary dictionaryWithDictionary:self.defaultHeaders];

    

    // HTTP header `Accept`
    headerParams[@"Accept"] = [SWGApiClient selectHeaderAccept:@[@"application/json", @"text/json", @"application/xml", @"text/xml"]];
    if ([headerParams[@"Accept"] length] == 0) {
        [headerParams removeObjectForKey:@"Accept"];
    }

    // response content type
    NSString *responseContentType;
    if ([headerParams objectForKey:@"Accept"]) {
        responseContentType = [headerParams[@"Accept"] componentsSeparatedByString:@", "][0];
    }
    else {
        responseContentType = @"";
    }

    // request content type
    NSString *requestContentType = [SWGApiClient selectHeaderContentType:@[]];

    // Authentication setting
    NSArray *authSettings = @[];

    id bodyParam = nil;
    NSMutableDictionary *formParams = [[NSMutableDictionary alloc] init];
    NSMutableDictionary *files = [[NSMutableDictionary alloc] init];
    
    
    

    
    return [self.apiClient requestWithCompletionBlock: resourcePath
                                               method: @"GET"
                                           pathParams: pathParams
                                          queryParams: queryParams
                                           formParams: formParams
                                                files: files
                                                 body: bodyParam
                                         headerParams: headerParams
                                         authSettings: authSettings
                                   requestContentType: requestContentType
                                  responseContentType: responseContentType
                                         responseType: @"SWGPrice*"
                                      completionBlock: ^(id data, NSError *error) {
                  
                  completionBlock((SWGPrice*)data, error);
              }
          ];
}



@end
