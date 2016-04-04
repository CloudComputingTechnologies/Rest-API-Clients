package io.swagger.api.factories;

import io.swagger.api.PriceApiService;
import io.swagger.api.impl.PriceApiServiceImpl;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-04-04T22:12:46.614+01:00")
public class PriceApiServiceFactory {

   private final static PriceApiService service = new PriceApiServiceImpl();

   public static PriceApiService getPriceApi()
   {
      return service;
   }
}
