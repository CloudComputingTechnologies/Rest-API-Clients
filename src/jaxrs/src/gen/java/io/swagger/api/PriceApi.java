package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.PriceApiService;
import io.swagger.api.factories.PriceApiServiceFactory;

import io.swagger.annotations.ApiParam;

import com.sun.jersey.multipart.FormDataParam;

import io.swagger.model.Price;
import java.util.Date;

import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;

@Path("/Price")


@io.swagger.annotations.Api(description = "the Price API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JaxRSServerCodegen", date = "2016-04-04T22:12:46.614+01:00")
public class PriceApi  {
   private final PriceApiService delegate = PriceApiServiceFactory.getPriceApi();

    @GET
    @Path("/{ticker}")
    
    @Produces({ "application/json", "text/json", "application/xml", "text/xml" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Price.class, responseContainer = "List", tags={ "Price",  })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Price.class, responseContainer = "List") })

    public Response priceGetByTicker(@ApiParam(value = "",required=true) @QueryParam("apikey") String apikey,@ApiParam(value = "",required=true) @PathParam("ticker") String ticker,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.priceGetByTicker(apikey,ticker,securityContext);
    }
    @GET
    @Path("/{ticker}/{date}")
    
    @Produces({ "application/json", "text/json", "application/xml", "text/xml" })
    @io.swagger.annotations.ApiOperation(value = "", notes = "", response = Price.class, tags={ "Price" })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 200, message = "OK", response = Price.class) })

    public Response priceGet(@ApiParam(value = "",required=true) @QueryParam("apikey") String apikey,@ApiParam(value = "",required=true) @PathParam("ticker") String ticker,@ApiParam(value = "",required=true) @PathParam("date") Date date,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.priceGet(apikey,ticker,date,securityContext);
    }
}
