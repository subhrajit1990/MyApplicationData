package my.application.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import my.application.rest.IndexController;


@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(IndexController.class);
	}
}
