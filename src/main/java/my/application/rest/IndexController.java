package my.application.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import my.application.services.Services;


@Path("/users")
public class IndexController {

	@Inject
	private Services services;

	@GET
	@Path("/topFive")
	@Produces(MediaType.APPLICATION_JSON)
    public Response topFive() {
    	
        Object toFiveResponse = services.topFiveService();
		return Response.ok(toFiveResponse).build();
	}
    
}
