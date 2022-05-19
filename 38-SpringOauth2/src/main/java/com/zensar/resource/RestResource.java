package com.zensar.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestResource 
{
	@RequestMapping("/api/users/me")
	public ResponseEntity<UserProfile> profile() 
	{
		//Build some dummy data to return for testing
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String email = user.getUsername() + "@Oauthjava.com";

		UserProfile profile = new UserProfile();
		profile.setName(user.getUsername());
		profile.setEmail(email);

		return ResponseEntity.ok(profile);
	}
}

/*
 1. API http://localhost:8080/api/users/me  ---->get
 
2. authorization grant from the resource owner from URL :
  http://localhost:8080/oauth/authorize?client_id=clientapp&response_type=code&scope=read_profile_info
  
  
3.  Access token request from postman
http://localhost:8080/oauth/token   ----->post
Headers:
Content-Type: application/x-www-form-urlencoded
authorization: Basic Y2xpZW50YXBwOjEyMzQ1Ng==
Form data - application/x-www-form-urlencoded:
grant_type=authorization_code
code=EAR76A
redirect_uri=http://localhost:8081/login
4. API http://localhost:8080/api/users/me
in post man get data using api and bearer token
 */
