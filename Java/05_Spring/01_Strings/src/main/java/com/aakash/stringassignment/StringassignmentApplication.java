package com.tony.stringassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringassignmentApplication {
	public static void main(String[] args) {
		SpringApplication.run(StringassignmentApplication.class, args);
	}
	
	@RequestMapping("/")
	public String Index(){
		return "Hello client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String Random(){
		return "Spring boot is great! So easy to respond with just strings.";
	}
}
