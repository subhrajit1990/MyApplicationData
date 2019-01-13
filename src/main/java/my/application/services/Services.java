package my.application.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.glassfish.jersey.internal.guava.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my.application.entity.CardList;
import my.application.entity.GuessMeAccount;
import my.application.entity.Product;
import my.application.entity.ProductImage;
import my.application.payload.GameMessage;
import my.application.payload.ProductRequest;
import my.application.payload.UserRequest;
import my.application.repositories.AllProductsRepository;
import my.application.repositories.CardListRepository;
import my.application.repositories.GuessMeAccountRepository;

@Service
public class Services {

	HashMap<String, Object> response = null;

	@Autowired
	GuessMeAccountRepository guessMeAccountRepository;

	@Autowired
	CardListRepository cardListRepository;

	@Autowired
	AllProductsRepository allProductsRepository;

	GameMessage msg = null;

	GuessMeAccount myAccount = null;

	public Object topFveService() {
		System.out.println("Hi I am executing 1st");
		ArrayList<Object> users = Lists.newArrayList(guessMeAccountRepository.findAll());
		System.out.println("Hi I am executing 2nd");
		response = new HashMap<String, Object>();
		response.put("Results", users);
		return response;
	}

	public Object cardListService() {
		System.out.println("Hi I am executing cardList");
		ArrayList<CardList> cardList = Lists.newArrayList(cardListRepository.findAll());
		System.out.println("Hi I am executing cardList 2nd");
		response = new HashMap<String, Object>();
		response.put("cards", cardList);
		return response;
	}

	public void scoreService(UserRequest commonRequest) {
		// TODO Auto-generated method stub
		System.out.println("Hi I am executing inserting score");
		myAccount = new GuessMeAccount();

		myAccount.setUsername(commonRequest.getUserName());
		myAccount.setEmail(commonRequest.getEmail());
		myAccount.setPoint(commonRequest.getPoint());
		guessMeAccountRepository.save(myAccount);
	}

	public Long nameCheckService(UserRequest commonRequest) {
		System.out.println("Hi I am executing nameCheck");
		
		// TODO Auto-generated method stub
		return guessMeAccountRepository.countById(commonRequest.getName());
	}

	public Object fetchProducts() {
		// TODO Auto-generated method stub
		// response = new HashMap<String, Object>();
		List<Object> allProductsResponse = allProductsRepository.fetchAll();

		return allProductsResponse;
	}

	public Object procuctDetails(ProductRequest productRequest) {
		// TODO Auto-generated method stub
		response = new HashMap<String, Object>();
		Product product = new Product();
		ProductImage productImage = new ProductImage();

		product.setProductId(productRequest.getProductId());
		product.setHeaderTopLeftText(productRequest.getHeaderTopLeftText());
		product.setHeaderTopRightText(productRequest.getHeaderTopRightText());
		product.setProductCtaText(productRequest.getProductCtaText());
		product.setProductDetails(productRequest.getProductDetails());
		product.setProductName(productRequest.getProductName());
		product.setProductPrice(productRequest.getProductPrice());

		productImage.setProductImageThumbnailUrl(productRequest.getProductImageThumbnailUrl());
		productImage.setProductImageUrl(productRequest.getProductImageUrl());

		product.setProductImage(productImage);

		productImage.setProduct(product);

		allProductsRepository.save(product);

		response.put("status", "success");
		return response;
	}

}
