package com.eniglio.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eniglio.workshopmongo.domain.User;
import com.eniglio.workshopmongo.repository.UserRepository;
import com.eniglio.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
	    Optional<User> userOptional = repo.findById(id);
	    return userOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + id));
	}
}
