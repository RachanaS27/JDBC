package com.zensar.olx.advertises.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@CrossOrigin(origins = "http://localhost:4200")

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
	
	@GetMapping("/user/advertiseById/{advId}")
	public AdvertisementPostResponse f4(@PathVariable(name="advId") int advertisementId) {
		AdvertisementPostResponse response = new AdvertisementPostResponse();
		Advertisement advt = this.service.getAdvertisementById(advertisementId);
		
		RestTemplate restTemplate=new RestTemplate();
		
		Category category;
		String url = "http://localhost:9052/advertise/getCategoryById/"+advt.getCategory().getId();
		category = restTemplate.getForObject(url, Category.class);
		advt.setCategory(category);
		System.out.println("Category----------"+advt);
		
	
		
		url = "http://localhost:9052/advertise/status/"+advt.getAdvertisementStatus().getId();
		AdvertisementStatus advertisementStatus;
		advertisementStatus = restTemplate.getForObject(url, AdvertisementStatus.class);
		advt.setAdvertisementStatus(advertisementStatus);
		
		url = "http://localhost:9051/findUserById/"+advt.getOlxUser().getUserId();
		OlxUser olxUser = restTemplate.getForObject(url, OlxUser.class);
		advt.setOlxUser(olxUser);

		response.setId(advt.getId());;
		response.setTitle(advt.getTitle());
		response.setDescription(advt.getDescription());
		response.setPrice(advt.getPrice());
		response.setUserName(advt.getOlxUser().getUserName());
		response.setCategory(advt.getCategory().getName());
		response.setCreatedDate(advt.getCreatedDate());
		response.setModifiedDate(advt.getModifiedDate());
		response.setStatus(advt.getAdvertisementStatus().getStatus());
		
		
		return response;
	}
	
	@DeleteMapping("/user/advertise/{aid}")
	public boolean f5(@PathVariable(name="aid")int advertisementId) {
		
		Advertisement advt = this.service.getAdvertisementById(advertisementId);
		
		boolean result = this.service.deleteAdvertisement(advt);
		
		
		return result;
	}
	
	@GetMapping("/advertise/search/{filterText}")
	public List<AdvertisementPostResponse> f6(@PathVariable(name="filterText")String filter) {
		
		List<Advertisement> advPost = this.service.getAllAdvertisement();
		
		String[] text = filter.split(":");

		List<Advertisement> selectedadvt = new ArrayList<>();
		RestTemplate restTemplate=new RestTemplate();

		String url;
		for (Advertisement post : advPost) {
			
			url = "http://localhost:9051/findUserById/"+post.getOlxUser().getUserId();
			OlxUser olxUser = restTemplate.getForObject(url, OlxUser.class);
			post.setOlxUser(olxUser);
			
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

			
			
			if(text[0].equalsIgnoreCase("id")) {
				if(post.getId()== Integer.parseInt(text[1]))
				{
					selectedadvt.add(post);
				}
			}
			if(text[0].equalsIgnoreCase("Title")) {
				if(post.getTitle().contains(text[1]))
				{
					selectedadvt.add(post);
				}
			}
			if(text[0].equalsIgnoreCase("price")) {
				if(post.getPrice() ==Float.parseFloat(text[1]))
				{
					selectedadvt.add(post);
				}
			}
			if(text[0].equalsIgnoreCase("description")) {
				if(post.getDescription().contains(text[1]))
				{
					selectedadvt.add(post);
				}
			}
			if(text[0].equalsIgnoreCase("userName")) {
				if(post.getOlxUser().getUserName().equalsIgnoreCase(text[1]))
				{
					selectedadvt.add(post);
				}
			}
			if(text[0].equalsIgnoreCase("createdDate")) {
				if(post.getCreatedDate().toString().equals((text[1])))
				{
					selectedadvt.add(post);
				}
			}
			if(text[0].equalsIgnoreCase("modifiedDate")) {
				if(post.getModifiedDate().toString().equals(text[1]))
				{
					selectedadvt.add(post);
				}
			}
			if(text[0].equalsIgnoreCase("status")) {
				if(post.getAdvertisementStatus().getStatus().equalsIgnoreCase(text[1]))
				{
					selectedadvt.add(post);
				}
			}
			if(text[0].equalsIgnoreCase("category")) {
				if(post.getCategory().getName().equalsIgnoreCase(text[1]))
				{
					selectedadvt.add(post);
				}
			}
			
		   /* if(str.contains(text[1])) {
		    selectedadvt.add(post);
		    }*/
		}
		
		List<AdvertisementPostResponse> responseList = new ArrayList<>();
		
		for (Advertisement advertisementPost : selectedadvt) {
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
