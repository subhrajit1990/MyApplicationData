package my.application.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import my.application.entities.ApplicationRequestWrapper;
import my.application.entities.CommonRequest;
import my.application.entities.GameMessage;
import my.application.services.Services;
import my.application.utils.Errors;
import my.application.utils.FailureException;

@RestController
@RequestMapping(value = "/users")
public class IndexController implements ErrorController {

	@Autowired
	Services services;

	@RequestMapping(value = {"/","/welcome"})

	public String welCome() {
		return "Welcome";
	}

	@RequestMapping(value = "/topFive", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

	public Object topFive() {

		Object topFiveResponse = services.topFveService();
		return topFiveResponse;
	}

	@RequestMapping(value = "/cardList", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

	public Object cardList() {
		
		Object cardListResponse = services.cardListService();
		
		return cardListResponse;
	}

	@RequestMapping(value = "/score", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public Object score(@RequestBody ApplicationRequestWrapper requestParams) {
		CommonRequest commonRequest = requestParams.getCommonRequest();
		GameMessage gameMessage = new GameMessage();
		try {
			services.scoreService(commonRequest);
			gameMessage.setMessage("Success");
		}catch (Exception e) {
			gameMessage.setMessage(Errors.PERSISTANCEERROR.getErrorMessage());
			gameMessage.setStatusCode(Errors.PERSISTANCEERROR.getErrorCode());
		}
		return gameMessage;
	}

	@RequestMapping(value = "/nameCheck", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)

	public Object nameCheck(@RequestBody ApplicationRequestWrapper requestParams) {
		CommonRequest commonRequest = requestParams.getCommonRequest();
		Object nameCheckResponse = services.nameCheckService(commonRequest);
		return nameCheckResponse;
	}

	@Override
	public String getErrorPath() {
		// TODO Auto-generated method stub
		return null;
	}
}
