package com.example.project.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.project.Model.ApplicationUser;


public class UserMapper {
	 public static UserPrincipal userToPrincipal(ApplicationUser user) {
	        UserPrincipal userp = new UserPrincipal();
	        //List<SimpleGrantedAuthority> authorities = user.getRoles().stream()
	           // .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName())).collect(Collectors.toList());

	        userp.setUsername(user.getUsername());
	        userp.setPassword(user.getPassword());
	        userp.setEnabled(true);
	        //userp.setAuthorities(authorities);
	        return userp;
	    }
}
