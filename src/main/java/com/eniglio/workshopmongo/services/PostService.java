package com.eniglio.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eniglio.workshopmongo.domain.Post;
import com.eniglio.workshopmongo.repository.PostRepository;
import com.eniglio.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
	    Optional<Post> postOptional = repo.findById(id);
	    return postOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado. Id: " + id));
	}
}
