package my.application.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import my.application.services.Services;


@RestController
public class IndexController {

	
	private Services services;

    @GetMapping("/")
    public String index() {
    	services = new Services();
        return services.topFive().toString();
    }
}
