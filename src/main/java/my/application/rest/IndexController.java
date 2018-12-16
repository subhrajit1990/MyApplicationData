package my.application.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RequestBody;

import my.application.entities.ApplicationRequestWrapper;
import my.application.entities.CommonRequest;
import my.application.entities.GameMessage;
import my.application.services.Services;

//@CrossOrigin(origins = {"https://justguess.herokuapp.com/","http://localhost:8080"}, maxAge = 3600)
@Path("/users")
public class IndexController {

	@Inject
	Services services;

	@GET
	@Path("/welcome")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response welCome() {
		return Response.ok("Welcome").build();
	}
	
	@GET
	@Path("/topFive")
	@Produces(MediaType.APPLICATION_JSON)
    public Response topFive() {
    	
        Object topFiveResponse = services.topFveService();
		return Response.ok(topFiveResponse).build();
	}
	
	@GET
	@Path("/cardList")
	@Produces(MediaType.APPLICATION_JSON)
    public Response cardList() {
    	
        Object cardListResponse = services.cardListService();
		return Response.ok(cardListResponse).build();
	}
	
	@POST
	@Path("/score")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response score(@RequestBody ApplicationRequestWrapper requestParams) {
		CommonRequest commonRequest = requestParams.getCommonRequest();
		GameMessage gameMessage = new GameMessage();
		try {
		 services.scoreService(commonRequest);
		 gameMessage.setMessage("Success");
			gameMessage.setStatusCode("0");
		}catch(Exception e) {
			gameMessage.setMessage("Error");
			gameMessage.setStatusCode("100");
		}
		return Response.ok(gameMessage).build();
	}
	
	@POST
	@Path("/nameCheck")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response nameCheck(@RequestBody ApplicationRequestWrapper requestParams) {
		CommonRequest commonRequest = requestParams.getCommonRequest();
		Object nameCheckResponse = services.nameCheckService(commonRequest);
		return Response.ok(nameCheckResponse).build();
	}
}
