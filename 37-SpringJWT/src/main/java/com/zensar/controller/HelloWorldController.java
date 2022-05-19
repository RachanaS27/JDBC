package com.zensar.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin()
public class HelloWorldController {

	@RequestMapping({ "/hello" })
	public String hello() {
		return "Hello World";
	}

}

/*
 
 1.http://localhost:8080/authenticate     ------>post
 {
     "username":"geethajava",
     "password": "password"
 }
 
2. Authorization 
 Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqYXZhaW51c2UiLCJleHAiOjE2NTI4NTc3ODksImlhdCI6MTY1MjgzOTc4OX0.9pjmz10gJ0IpuzQq_SHS6PZLZEmjUWnuNeloC7WQUTuATJQTlR_I6UpLJhbJr_LaNyoYaTBZbuO5UJ_Ks0Tw2A
 
 http://localhost:8080/hello    ------------------>get
 
 */
