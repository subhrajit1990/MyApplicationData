package my.application.services;


import java.util.ArrayList;
import java.util.HashMap;

import javax.inject.Inject;

import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.stereotype.Service;

import my.application.entities.CardList;
import my.application.entities.CommonRequest;
import my.application.entities.GuessMeAccount;
import my.application.entities.GameMessage;
import my.application.repositories.CardListRepository;
import my.application.repositories.GuessMeAccountRepository;


@Service
public class Services {
	
	HashMap<String, Object> response = null;
	
	@Inject
	GuessMeAccountRepository guessMeAccountRepository;
	
	@Inject
	CardListRepository cardListRepository;
	
	GameMessage msg = null;
	
	public Object topFveService() {
		System.out.println("Hi I am executing 1st");
		ArrayList<Object> users = Lists.newArrayList(guessMeAccountRepository.topFive());
		System.out.println("Hi I am executing 2nd");
		response = new HashMap<String, Object>();
		response.put("Results",users);
		return response;
	}

	public Object cardListService() {
		System.out.println("Hi I am executing cardList");
		ArrayList<CardList> cardList = Lists.newArrayList(cardListRepository.findAll());
		System.out.println("Hi I am executing cardList 2nd");
		response = new HashMap<String, Object>();
		response.put("cards",cardList);
		return response;
	}

	public Object scoreService() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object nameCheckService(CommonRequest commonRequest) {
		System.out.println("Hi I am executing nameCheck");
		msg = new GameMessage();
		if(guessMeAccountRepository.countById(commonRequest.getName()) > 0) {
			msg.setMessage("User Name Existis, please try a new name");
			msg.setStatusCode("100");
		}else {
			msg.setMessage("Please continue");
			msg.setStatusCode("0");
		}
		// TODO Auto-generated method stub
		return msg;
	}

	
}
