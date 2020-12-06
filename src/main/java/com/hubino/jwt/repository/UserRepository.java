package com.hubino.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hubino.jwt.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
                  
		UserEntity findByUserName(String userName);   
		
		
		UserEntity findByEmail(String email);
		
		Boolean existsByUserName(String username);

		Boolean existsByEmail(String email);
}
