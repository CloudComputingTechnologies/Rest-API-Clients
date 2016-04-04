<?php
require_once __DIR__ . '/vendor/autoload.php';

use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Silex\Application;

$app = new Silex\Application();

    
        
            

$app->GET('/Price/{ticker}', function(Application $app, Request $request, $ticker) {
            $apikey = $request->get('apikey');    
            
            return new Response('How about implementing priceGetByTicker as a GET method ?');
            });

            

$app->GET('/Price/{ticker}/{date}', function(Application $app, Request $request, $ticker, $date) {
            $apikey = $request->get('apikey');    
            
            return new Response('How about implementing priceGet as a GET method ?');
            });

            
        
    

$app->run();
