package my.application.services;


import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.stereotype.Service;

import my.application.entities.GuessMeAccount;
import my.application.repositories.GuessMeAccountRepository;



@Service
public class Services {
	
	HashMap<String, Object> response = null;
	
	@Inject
	GuessMeAccountRepository guessMeAccountRepository;
	
	public Object topFiveService() {
		System.out.println("Hi I am executing 1st");
		ArrayList<GuessMeAccount> users = Lists.newArrayList(guessMeAccountRepository.findAll());
		System.out.println("Hi I am executing 2nd");
		response = new HashMap<String, Object>();
		response.put("Results",users);
		return response;
	}
}
