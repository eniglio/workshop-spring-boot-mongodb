package com.eniglio.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eniglio.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	//Spring Data mongoDB - consultar no site
	List<Post> findByTitleContainingIgnoreCase(String text);
	
}
