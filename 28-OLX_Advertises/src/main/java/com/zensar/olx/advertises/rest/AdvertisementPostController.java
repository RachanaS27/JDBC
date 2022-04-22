package com.zensar.olx.advertises.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.olx.advertises.bean.Advertisement;
import com.zensar.olx.advertises.bean.AdvertisementPostRequest;
import com.zensar.olx.advertises.bean.AdvertisementPostResponse;
import com.zensar.olx.advertises.bean.AdvertisementStatus;
import com.zensar.olx.advertises.bean.Category;
import com.zensar.olx.advertises.bean.OlxUser;
import com.zensar.olx.advertises.service.AdvertisementPostService;

@RestController
public class AdvertisementPostController {

	@Autowired
	AdvertisementPostService service;

	@PostMapping("/advertise/{un}")
	public AdvertisementPostResponse add(@RequestBody AdvertisementPostRequest request,
			@PathVariable(name = "un") String userName) {

		Advertisement advt = new Advertisement();
		advt.setTitle(request.getTitle());
		advt.setPrice(request.getPrice());
		advt.setDescription(request.getDescription());

		int categoryId = request.getCategoryId();

		RestTemplate restTemplate = new RestTemplate();
		Category category;
		String url = "http://localhost:9052/advertise/getCategoryById/" + categoryId;
		category = restTemplate.getForObject(url, Category.class);
		advt.setCategory(category);

		url = "http://localhost:9051/findUserByname/" + userName;
		OlxUser olxUser = restTemplate.getForObject(url, OlxUser.class);
		advt.setOlxUser(olxUser);

		AdvertisementStatus advertisementStatus = new AdvertisementStatus(1, "OPEN");
		advt.setAdvertisementStatus(advertisementStatus);

		Advertisement advertisement = this.service.addAdvertisement(advt);

		AdvertisementPostResponse response = new AdvertisementPostResponse();
		response.setId(advertisement.getId());
		response.setTitle(advertisement.getTitle());
		response.setPrice(advertisement.getPrice());
		response.setCategory(advertisement.getCategory().getName());
		response.setDescription(advertisement.getDescription());
		response.setUserName(advertisement.getOlxUser().getUserName());
		response.setCreatedDate(advertisement.getCreatedDate());
		response.setModifiedDate(advertisement.getModifiedDate());
		response.setStatus(advertisement.getAdvertisementStatus().getStatus());

		return response;
	}

	@PutMapping("/advertise/{aid}/{userName}")
	public AdvertisementPostResponse f2(@RequestBody AdvertisementPostRequest request,
			@PathVariable(name = "aid") int id, @PathVariable(name = "userName") String userName) {
		
		Advertisement advt=this.service.getAdvertisementById(id);
		
		advt.setTitle(request.getTitle());
		advt.setDescription(request.getDescription());
		advt.setPrice(request.getPrice());
		
		RestTemplate restTemplate=new RestTemplate();
		
		Category category;
		String url = "http://localhost:9052/advertise/getCategoryById/"+request.getCategoryId();
		category = restTemplate.getForObject(url, Category.class);
		advt.setCategory(category);
		
		url = "http://localhost:9051/findUserByname/"+userName;
		OlxUser olxUser = restTemplate.getForObject(url, OlxUser.class);
		advt.setOlxUser(olxUser);

		url = "http://localhost:9052/advertise/status/"+request.getStatusId();
		AdvertisementStatus advertisementStatus;
		advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
		advt.setAdvertisementStatus(advertisementStatus);
		
		Advertisement advertisement = this.service.updateAdvertisement(advt);
		
		AdvertisementPostResponse response = new AdvertisementPostResponse();
		
		
		response.setId(advertisement.getId());
		response.setTitle(advertisement.getTitle());
		response.setPrice(advertisement.getPrice());
		response.setCategory(advertisement.getCategory().getName());
		response.setDescription(advertisement.getDescription());
		response.setUserName(advertisement.getOlxUser().getUserName());
		response.setCreatedDate(advertisement.getCreatedDate());
		response.setModifiedDate(advertisement.getModifiedDate());
		response.setStatus(advertisement.getAdvertisementStatus().getStatus());

		return response;
	}
	
	
	@GetMapping("advertise/{userName}")
	public List<AdvertisementPostResponse> f3(@PathVariable(name="userName")String userName){
		
		List<Advertisement> advPost = this.service.getAllAdvertisement();
		
		RestTemplate restTemplate=new RestTemplate();
		String url ="http://localhost:9051/findUserByname/"+userName;
		OlxUser olxUser = restTemplate.getForObject(url, OlxUser.class);
		
		List<Advertisement> filterList = new ArrayList<>();
		
		for (Advertisement post : advPost) {
			Category category;
			url="http://localhost:9052/advertise/getCategoryById/"+post.getCategory().getId();
			category=restTemplate.getForObject(url, Category.class);
			post.setCategory(category);
			System.out.println("Category-------"+post);
			
			url="http://localhost:9052/advertise/status/"+post.getAdvertisementStatus().getId();
			AdvertisementStatus advertisementStatus;
			advertisementStatus=restTemplate.getForObject(url, AdvertisementStatus.class);
			post.setAdvertisementStatus(advertisementStatus);
			System.out.println("AdvertisementStatus---"+post);
			
			if(olxUser.getUserId()==post.getOlxUser().getUserId()) {
				post.setOlxUser(olxUser);
				filterList.add(post);
			}
			
		}
		
		System.out.println("List-----------"+filterList);
		
		List<AdvertisementPostResponse> responseList = new ArrayList<>();
		
		for (Advertisement advertisementPost : filterList) {
			AdvertisementPostResponse postResponse = new AdvertisementPostResponse();
			
			postResponse.setId(advertisementPost.getId());;
			postResponse.setTitle(advertisementPost.getTitle());
			postResponse.setDescription(advertisementPost.getDescription());
			postResponse.setPrice(advertisementPost.getPrice());
			postResponse.setUserName(advertisementPost.getOlxUser().getUserName());
			postResponse.setCategory(advertisementPost.getCategory().getName());
			postResponse.setCreatedDate(advertisementPost.getCreatedDate());
			postResponse.setModifiedDate(advertisementPost.getModifiedDate());
			postResponse.setStatus(advertisementPost.getAdvertisementStatus().getStatus());
			
			responseList.add(postResponse);
			
		}
		
		return responseList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
