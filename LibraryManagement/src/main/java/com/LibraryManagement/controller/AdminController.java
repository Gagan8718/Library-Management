package com.LibraryManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.LibraryManagement.Services.AdminServices;
import com.LibraryManagement.model.AdminBean;

@RestController
@RequestMapping("/users")

public class AdminController {
	@Autowired
	private AdminServices adminService;


	   

	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody AdminBean user) {
//	    	System.out.println(user.getUsername());
	        if (adminService.authenticate(user.getUsername(),user.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        }
	        else {
	            return ResponseEntity.badRequest().body("Login failed");
	        }
	    }
	

	

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody AdminBean user) {
		adminService.register(user);
		return ResponseEntity.ok("User registered successfully");

	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
		if (adminService.authenticate("shivam", "Shivam@96")) {
			return ResponseEntity.ok("Login successful");
		} else {
			return ResponseEntity.badRequest().body("Login failed");
		}
	}

}
