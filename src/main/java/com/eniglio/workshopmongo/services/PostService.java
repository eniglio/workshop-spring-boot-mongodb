package com.eniglio.workshopmongo.services;

import java.util.Date;
import java.util.List;
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
	
	public List<Post> findByTitle(String text) {
		//return repo.findByTitleContainingIgnoreCase(text);
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 + 60 + 60 * 1000);
		return repo.fullSearch(text, minDate, maxDate);
	}
}
