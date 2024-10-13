package com.dannotes.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dannotes.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
