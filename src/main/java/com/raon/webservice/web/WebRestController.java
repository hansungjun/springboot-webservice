package com.raon.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raon.webservice.web.domain.posts.PostsInsertDto;
import com.raon.webservice.web.domain.posts.PostsRepository;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsRepository postsRepository;
	
	@GetMapping("/hello")
	public String helloWorld() {
		return " Hello! World ! ";
	}
	
	@PostMapping("/posts")
	public void insertPosts(PostsInsertDto dto) {
		postsRepository.save(dto.toEntity());
	}
	
}
