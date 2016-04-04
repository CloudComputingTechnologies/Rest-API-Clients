package io.swagger.api;

import io.swagger.model.*;

import io.swagger.model.Price;
import java.util.Date;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static org.springframework.http.MediaType.*;

@Controller
@RequestMapping(value = "/Price", produces = {APPLICATION_JSON_VALUE})
@Api(value = "/Price", description = "the Price API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-04-04T22:16:14.748+01:00")
public class PriceApi {
  

  @ApiOperation(value = "", notes = "", response = Price.class, responseContainer = "List")
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "OK") })
  @RequestMapping(value = "/{ticker}", 
    produces = { "application/json", "text/json", "application/xml", "text/xml" }, 
    
    method = RequestMethod.GET)
  public ResponseEntity<List<Price>> priceGetByTicker(@ApiParam(value = "", required = true) @RequestParam(value = "apikey", required = true) String apikey


,
    
@ApiParam(value = "",required=true ) @PathVariable("ticker") String ticker

)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<List<Price>>(HttpStatus.OK);
  }

  

  @ApiOperation(value = "", notes = "", response = Price.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "OK") })
  @RequestMapping(value = "/{ticker}/{date}", 
    produces = { "application/json", "text/json", "application/xml", "text/xml" }, 
    
    method = RequestMethod.GET)
  public ResponseEntity<Price> priceGet(@ApiParam(value = "", required = true) @RequestParam(value = "apikey", required = true) String apikey


,
    
@ApiParam(value = "",required=true ) @PathVariable("ticker") String ticker

,
    
@ApiParam(value = "",required=true ) @PathVariable("date") Date date

)
      throws NotFoundException {
      // do some magic!
      return new ResponseEntity<Price>(HttpStatus.OK);
  }

  
}
