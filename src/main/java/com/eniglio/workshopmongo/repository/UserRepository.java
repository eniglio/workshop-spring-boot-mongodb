package com.eniglio.workshopmongo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eniglio.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	List<User> findAll();

	@SuppressWarnings({ "unchecked", "rawtypes" })
	Optional findById(String id);
	
}
