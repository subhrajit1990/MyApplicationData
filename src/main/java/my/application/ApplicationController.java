package my.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



//@ComponentScan({"my.application.repositories","my.application.services","my.application.entities"})
//@SpringBootApplication(scanBasePackages={"my.application"})

@SpringBootApplication
public class ApplicationController {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ApplicationController.class, args);
		
	}
}
