package com.raon.webservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.raon.webservice.web.domain.posts.Posts;
import com.raon.webservice.web.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postRepository;
	
	@After
	public void cleanup() {
		postRepository.deleteAll();
	}
	
	@Test
	public void test() {
		
		//given
		postRepository.save(Posts.builder().title("타이틀").content("컨텐츠").author("author").build());
		
		//when
		List<Posts> postsList = postRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("타이틀"));
		assertThat(posts.getContent(), is("컨텐츠"));
		
	}
	
	
}
