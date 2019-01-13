package my.application.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.application.payload.GameMessage;
import my.application.payload.ProductRequest;
import my.application.payload.ProductRequestWrapper;
import my.application.payload.ResponseBody;
import my.application.payload.ResponseHeader;
import my.application.payload.ResponseWrapper;
import my.application.payload.UserRequest;
import my.application.payload.UserRequestWrapper;
import my.application.services.Services;
import my.application.utils.CUSTOMMESSAGES;
import my.application.utils.FailureException;

@RestController
@RequestMapping(value = "/users")
public class IndexController implements ErrorController {

	@Autowired
	Services services;

	ResponseWrapper responseWrapper = null;

	ResponseHeader responseHeader = null;

	ResponseBody responseBody = null;

	@RequestMapping(value = { "/welcome" })

	public String welCome() {
		return "Welcome";
	}

	@RequestMapping(value = "/topFive", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public Object topFive() {

		Object topFiveResponse = services.topFveService();
		return topFiveResponse;
	}

	@RequestMapping(value = "/cardList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public Object cardList() {

		Object cardListResponse = services.cardListService();

		return cardListResponse;
	}

	@RequestMapping(value = "/score", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public Object score(@RequestBody UserRequestWrapper requestParams) {
		UserRequest commonRequest = requestParams.getCommonRequest();
		GameMessage gameMessage = new GameMessage();
		try {
			services.scoreService(commonRequest);
			gameMessage.setMessage("Success");
		} catch (Exception e) {
			gameMessage.setMessage(CUSTOMMESSAGES.PERSISTANCEERROR.getMessage());
			gameMessage.setStatusCode(CUSTOMMESSAGES.PERSISTANCEERROR.getCode());
		}
		return gameMessage;
	}

	@RequestMapping(value = "/nameCheck", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public Object nameCheck(@RequestBody UserRequestWrapper requestParams) {
		UserRequest commonRequest = requestParams.getCommonRequest();
		Object nameCheckResponse = services.nameCheckService(commonRequest);
		return nameCheckResponse;
	}

	@RequestMapping(value = "/fetchProducts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseWrapper fetchProducts() {
		Object productsResponse = null;
		responseHeader = new ResponseHeader();
		responseWrapper = new ResponseWrapper();
		responseBody = new ResponseBody();
		try {
			productsResponse = services.fetchProducts();
			responseHeader.setStatusCode(CUSTOMMESSAGES.SUCCESS.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.SUCCESS.getMessage());
			responseBody.setRespnse(productsResponse);
			responseWrapper.setResponseBody(responseBody);
			
		} catch (EmptyResultDataAccessException e) {
			responseHeader.setStatusCode(CUSTOMMESSAGES.PERSISTANCEERROR.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.PERSISTANCEERROR.getMessage());
			responseBody.setResponseMessage(CUSTOMMESSAGES.NODATA.getMessage());
			responseBody.setResponseStatus(CUSTOMMESSAGES.NODATA.getCode());
			responseWrapper.setResponseBody(responseBody);
		} catch (Exception e) {
			responseHeader.setStatusCode(CUSTOMMESSAGES.PERSISTANCEERROR.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.PERSISTANCEERROR.getMessage());
		}
		
		responseWrapper.setResponseHeader(responseHeader);
		return responseWrapper;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseWrapper productDetails(@RequestBody ProductRequestWrapper productRequestWrapper) throws Exception {
		Object productDetailsReponse = null;
		responseHeader = new ResponseHeader();
		responseWrapper = new ResponseWrapper();
		responseBody = new ResponseBody();
		ProductRequest productRequest = productRequestWrapper.getProductRequest();
		System.out.println("Hi Executiing the product insretion");
		try {
			productDetailsReponse = services.procuctDetails(productRequest);
			System.out.println("Hi Executiing done the product insretion");
			responseHeader.setStatusCode(CUSTOMMESSAGES.SUCCESS.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.SUCCESS.getMessage());
			responseBody.setRespnse(productDetailsReponse);
			responseWrapper.setResponseBody(responseBody);
		} catch (Exception e) {
			
			System.out.println("Hi Executiing exception the product insretion");
			responseHeader.setStatusCode(CUSTOMMESSAGES.PERSISTANCEERROR.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.PERSISTANCEERROR.getMessage());
		}

		responseWrapper.setResponseHeader(responseHeader);
		return responseWrapper;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
}
