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
		Object topFiveResponse = null;
		try {
			topFiveResponse = services.topFveService();

			responseHeader.setStatusCode(CUSTOMMESSAGES.SUCCESS.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.SUCCESS.getMessage());
			responseBody.setRespnse(topFiveResponse);
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

	@RequestMapping(value = "/cardList", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseWrapper cardList() {

		responseHeader = new ResponseHeader();
		responseWrapper = new ResponseWrapper();
		responseBody = new ResponseBody();
		Object cardListResponse = null;
		try {
			cardListResponse = services.cardListService();

			responseHeader.setStatusCode(CUSTOMMESSAGES.SUCCESS.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.SUCCESS.getMessage());
			responseBody.setRespnse(cardListResponse);
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

	@RequestMapping(value = "/score", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseWrapper score(@RequestBody UserRequestWrapper requestParams) {

		responseHeader = new ResponseHeader();
		responseWrapper = new ResponseWrapper();
		responseBody = new ResponseBody();

		UserRequest commonRequest = requestParams.getCommonRequest();
		GameMessage gameMessage = new GameMessage();
		try {
			services.scoreService(commonRequest);
			gameMessage.setMessage("Success");

			responseHeader.setStatusCode(CUSTOMMESSAGES.SUCCESS.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.SUCCESS.getMessage());
			responseBody.setRespnse(gameMessage.getMessage());
			responseWrapper.setResponseBody(responseBody);

		} catch (Exception e) {

			responseHeader.setStatusCode(CUSTOMMESSAGES.PERSISTANCEERROR.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.PERSISTANCEERROR.getMessage());
		}
		responseWrapper.setResponseHeader(responseHeader);
		return responseWrapper;
	}

	@RequestMapping(value = "/nameCheck", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public ResponseWrapper nameCheck(@RequestBody UserRequestWrapper requestParams) {
		responseHeader = new ResponseHeader();
		responseWrapper = new ResponseWrapper();
		responseBody = new ResponseBody();
		Long nameCheckResponse = null;

		UserRequest commonRequest = requestParams.getCommonRequest();
		try {
			nameCheckResponse = services.nameCheckService(commonRequest);
			
			GameMessage msg = new GameMessage();
			if (nameCheckResponse > 0) {
				msg.setMessage(CUSTOMMESSAGES.NAMEEXISTS.getMessage());
				msg.setStatusCode(CUSTOMMESSAGES.NAMEEXISTS.getCode());
			} else {
				msg.setMessage(CUSTOMMESSAGES.NAMENOTEXISTS.getMessage());
				msg.setStatusCode(CUSTOMMESSAGES.NAMENOTEXISTS.getCode());
			}
			
			responseHeader.setStatusCode(CUSTOMMESSAGES.SUCCESS.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.SUCCESS.getMessage());
			responseBody.setRespnse(msg);
			responseWrapper.setResponseBody(responseBody);
		} catch (Exception e) {
			responseHeader.setStatusCode(CUSTOMMESSAGES.PERSISTANCEERROR.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.PERSISTANCEERROR.getMessage());
		}
		responseWrapper.setResponseHeader(responseHeader);
		return responseWrapper;
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
		try {
			productDetailsReponse = services.procuctDetails(productRequest);
			responseHeader.setStatusCode(CUSTOMMESSAGES.SUCCESS.getCode());
			responseHeader.setStatusMessage(CUSTOMMESSAGES.SUCCESS.getMessage());
			responseBody.setRespnse(productDetailsReponse);
			responseWrapper.setResponseBody(responseBody);
		} catch (Exception e) {
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
