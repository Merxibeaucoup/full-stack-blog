package com.edgar.bloggy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edgar.bloggy.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 User findByUsername(String username);

}
