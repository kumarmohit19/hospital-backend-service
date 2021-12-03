package com.example.project.controller;


import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.project.Model.ApplicationUser;
import com.example.project.exception.ApplicationUserNotFoundException;
import com.example.project.security.JwtUtil;
import com.example.project.service.ApplicationUserService;
import com.example.project.service.UserAuthService;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
public class ApplicationUserController {

	@Autowired
    AuthenticationManager authenticationManager;
	
	@Autowired
	private ApplicationUserService applicationUserService;
	
	@Autowired
	private JwtUtil tokenProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping(value = "/viewprofiles")
	List<ApplicationUser> findAll() {
		return applicationUserService.getAllApplicationUsers();
	}
		
	@PostMapping("/signin")
    public ResponseEntity<Map<String, Object>> authenticateUser(@RequestBody ApplicationUser userLoginInfo) {      
        try {
        	Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(userLoginInfo.getUsername(), userLoginInfo.getPassword()));
                SecurityContextHolder.getContext().setAuthentication(authentication);
        	//ApplicationUser existingUser = applicationUserService.getApplicationUserById(id)
    				//.orElseThrow(() -> new ApplicationUserNotFoundException("ApplicationUser with ID :" + id));
        	String jwt = tokenProvider.generateToken(authentication);
			Map<String, Object> resMap = new HashMap<>();
			resMap.put("message","Authentication successful!");
			resMap.put("token", jwt);
			resMap.put("id", userLoginInfo.getUsername());
			return ResponseEntity.ok().body(resMap);
		}
		catch(Exception e) {
			Map<String, Object> resMap = new HashMap<>();
			resMap.put("message","Username or Password is Incorrect.");
			return ResponseEntity.ok().body(resMap);
		}
    }

	@GetMapping(value = "/viewprofile/{userId}")
	ResponseEntity<Map<String, Object>> findById(@PathVariable("userId") String userId) {
		ApplicationUser appUser = applicationUserService.getApplicationUserById(userId)
				.orElseThrow(() -> new ApplicationUserNotFoundException("ApplicationUser with ID :" + userId));
		ObjectMapper m = new ObjectMapper();
		Map<String,Object> props = m.convertValue(appUser, Map.class);
		props.put("user_name", props.get("username"));
		//ApplicationUser anotherBean = m.convertValue(props, ApplicationUser.class);
		return ResponseEntity.ok().body(props);
	}

	@PostMapping(value = "/register")
	public ResponseEntity<?> createEmployee(@Valid @RequestBody ApplicationUser userRegisterInfo) {
		try {
			userRegisterInfo.setPassword(passwordEncoder.encode(userRegisterInfo.getPassword()));
			ApplicationUser addedEmp = applicationUserService.saveApplicationUser(userRegisterInfo);
			Map<String, Object> resMap = new HashMap<>();
			resMap.put("message","Registration successful");
			return ResponseEntity.ok().body(resMap);
		}
		catch(Exception e) {
			Map<String, Object> resMap = new HashMap<>();
			resMap.put("message","Password or username policy failed");
			return ResponseEntity.ok().body(resMap);
		}
	}
		

	@PutMapping(value = "/editprofile/{userId}")
	ResponseEntity<ApplicationUser> updateEmployee(@PathVariable("userId") String userId,
			 @RequestBody ApplicationUser updatedUser) {
		ApplicationUser existingUser = applicationUserService.getApplicationUserById(userId)
				.orElseThrow(() -> new ApplicationUserNotFoundException("ApplicationUser with ID :" + userId));

		updatedUser.setUsername(existingUser.getUsername());
		applicationUserService.saveApplicationUser(updatedUser);

		return ResponseEntity.ok().body(updatedUser);
	}

}
