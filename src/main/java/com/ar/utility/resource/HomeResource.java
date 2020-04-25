package com.ar.utility.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	@GetMapping(value = "/")
	public String all() {
		return "A page where any one can land";
	}
	
	@GetMapping(value = "/user")
	public String user() {
		return "A page where user and admin can access";
	}
	
	@GetMapping(value = "/admin")
	public String admin() {
		return "A page where only admin can access";
	}
	
	@GetMapping("/about")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "<b>Hello World</b>");
		return model;
	}
	
	
}
