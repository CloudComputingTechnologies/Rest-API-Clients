<?php
/**
 * Cloud.Finance.Rest
 * @version v1
 */

require_once __DIR__ . '/vendor/autoload.php';

$app = new Slim\App();


/**
 * GET priceGetByTicker
 * Summary: 
 * Notes: 
 * Output-Formats: [application/json, text/json, application/xml, text/xml]
 */
$app->GET('/Price/{ticker}', function($request, $response, $args) {
            
            $queryParams = $request->getQueryParams();
            $apikey = $queryParams['apikey'];    
            
            
            $response->write('How about implementing priceGetByTicker as a GET method ?');
            return $response;
            });


/**
 * GET priceGet
 * Summary: 
 * Notes: 
 * Output-Formats: [application/json, text/json, application/xml, text/xml]
 */
$app->GET('/Price/{ticker}/{date}', function($request, $response, $args) {
            
            $queryParams = $request->getQueryParams();
            $apikey = $queryParams['apikey'];    
            
            
            $response->write('How about implementing priceGet as a GET method ?');
            return $response;
            });



$app->run();
