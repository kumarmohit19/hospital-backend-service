package com.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;

import com.example.project.Model.ApplicationUser;
import com.example.project.repository.ApplicationUserRepository;



@Service
public class ApplicationUserService {
	
	@Autowired
	private  ApplicationUserRepository applicationUserRepository;

    public void deleteApplicationUser(String appintId) {
    	applicationUserRepository.deleteById(appintId);
    }

    public List<ApplicationUser> getAllApplicationUsers() {
    	return applicationUserRepository.findAll();
    }
    
	public Optional<ApplicationUser> getApplicationUserById(String id) {

		return applicationUserRepository.findById(id);
	}

	public ApplicationUser saveApplicationUser(ApplicationUser newApplicationUser) {

		return applicationUserRepository.save(newApplicationUser);
	}
}

