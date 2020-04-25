package com.ar.utility;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ar.utility.config.CORSFilter;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:4200")
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
	
	
	

}
