package com.gs.rest.userJPA;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



@RestController
public class UserRestControllerJPA {
	
	//find all user 
	@Autowired
	UserDAOServiceJPA daoService ;
	@Autowired
	UserRepository  userRepository ;
	
	@Autowired
	PostRepository postRepository;
	
	
	@GetMapping("/usersjpa")
	public List<UserJPA> findAllUser(){
		return userRepository.findAll();
	}
	
	@GetMapping("/usersjpa/{id}")
	public Resource<UserJPA> findOneUser(@PathVariable int id) {
		Optional<UserJPA> user = userRepository.findById(id);
		if(!user.isPresent()) {
			throw new UserNotFoundException("Id:"+id);
		}
		//HATEOS
		Resource<UserJPA> resource = new Resource<UserJPA>(user.get()) ;
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllUser());
		resource.add(linkTo.withRel("all-usersjpa"));
		return resource;
	}
	//HATEOS 
	// H -HYPERMIDIA AS THE ENGINE OF PPLICATION STATUS 
	//output - status for CREATED AND CREATED URI 
	@PostMapping("/usersjpa")
	public ResponseEntity<Object> save(@Valid @RequestBody UserJPA user) {
		UserJPA saveUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("{id}")
		.buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/usersjpa/{id}")
	public void deleteById(@PathVariable int id) {
		userRepository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) {
		Optional<UserJPA> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return userOptional.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		Optional<UserJPA> userOptional = userRepository.findById(id);
		
		if(!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		UserJPA user = userOptional.get();
		
		post.setUser(user);
		
		postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}
