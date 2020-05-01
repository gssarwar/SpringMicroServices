package com.gs.rest.user;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

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
public class UserRestController {
	
	//find all user 
	@Autowired
	UserDAOService daoService ;
	
	@GetMapping("/users")
	public List<User> findAllUser(){
		return daoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Resource<User> findOneUser(@PathVariable int id) {
		User user = daoService.findOne(id);
		if(user == null) {
			throw new UserNotFoundException("Id:"+id);
		}
		//HATEOS
		Resource<User> resource = new Resource<User>(user) ;
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAllUser());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}
	//HATEOS 
	// H -HYPERMIDIA AS THE ENGINE OF PPLICATION STATUS 
	//output - status for CREATED AND CREATED URI 
	@PostMapping("/users")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		User saveUser = daoService.Save(user);
		
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("{id}")
		.buildAndExpand(saveUser.getId()).toUri();
		
		
		return ResponseEntity.created(location).build();
	}
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id) {
		User user = daoService.deleteById(id);
		if(user == null) {
			throw new UserNotFoundException("Id:"+id);
		}
	}
}
