package io.swagger.api;

import io.swagger.api.*;
import io.swagger.model.*;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.Price;
import java.util.Date;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-04-04T22:12:46.614+01:00")
public abstract class PriceApiService {
  
      public abstract Response priceGetByTicker(String apikey,String ticker,SecurityContext securityContext)
      throws NotFoundException;
  
      public abstract Response priceGet(String apikey,String ticker,Date date,SecurityContext securityContext)
      throws NotFoundException;
  
}
