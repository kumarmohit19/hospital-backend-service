package com.example.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Model.ApplicationUser;

import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationUserRepository  extends JpaRepository<ApplicationUser, String>{
	 Optional<ApplicationUser> findByUsername(String username);
}
