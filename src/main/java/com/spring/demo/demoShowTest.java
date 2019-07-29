package com.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class demoShowTest {
	
	  @Autowired 
	  valueTest test;
	  @Autowired
	  arrayTest ttt;
	  
	  @RequestMapping("/1") 
	  String index() {
		  return test.getFlowers()+"0000000"+test.getToy(); 
	}
	 @RequestMapping("/2")
	 public String getsdd() {
		 return ttt.getFlowers()+"11111111111"+ttt.getToy();
	 }
	

}
