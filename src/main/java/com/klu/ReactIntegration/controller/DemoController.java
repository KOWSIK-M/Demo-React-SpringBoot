package com.klu.ReactIntegration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.ReactIntegration.model.DemoUser;
import com.klu.ReactIntegration.service.DemoUserService;

@RestController
@RequestMapping("/api/demo")
public class DemoController {
	
	@Autowired
	private DemoUserService userService;
	
	@GetMapping("/getall")
	public ResponseEntity<?> getAllUsers(){
		try {
			List<DemoUser> users = userService.getAll();
			return ResponseEntity.ok().body(users);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}
	
	@PostMapping("v1")
	public ResponseEntity<?> postUserString(@RequestBody DemoUser user){
		try {
			String response = userService.addUserString(user);
			if(response.equals("Added User Successfully")) {
				return ResponseEntity.ok().body(response);
			}else {
				return ResponseEntity.badRequest().body(response);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
		
	}
	
	@PostMapping("v2")
	public ResponseEntity<?> httpsUserBoolean(@RequestBody DemoUser user){
		try {
			Boolean response = userService.addUserBoolean(user);
			if (response.equals(true)) {
				return ResponseEntity.badRequest().body(response);
			} else {
				return ResponseEntity.badRequest().body(response);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}
}
