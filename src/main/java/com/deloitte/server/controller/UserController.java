package com.deloitte.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deloitte.server.model.Product;
import com.deloitte.server.model.User;
import com.deloitte.server.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/user/all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = service.getAllUsers();
		ResponseEntity<List<User>> reul = new ResponseEntity<List<User>>(allUsers, HttpStatus.OK);
		return reul;
	}

	@PostMapping("/user/add")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User usr = service.addUser(user);
		ResponseEntity<User> reu = new ResponseEntity<User>(usr, HttpStatus.CREATED);
		return reu;
	}
	
	@GetMapping("/user/{username}")
	public ResponseEntity<User> getUserByUsername(@PathVariable("username") String uname) {
		User usr = service.getUserByUsername(uname);
		ResponseEntity<User> reu = new ResponseEntity<User>(usr, HttpStatus.FOUND);
		return reu;
	}
	
	@PostMapping("/user/update")
	public ResponseEntity<User> updateUserByUsername(@RequestBody User user) {
		User usr = service.updateUser(user);
		ResponseEntity<User> reu = new ResponseEntity<User>(usr,HttpStatus.OK);
		return reu;
	}
	
	@GetMapping("/user/{username}/favourites")
	public ResponseEntity<List<Product>> getUserFavourites(@PathVariable("username") String uname) {
		List<Product> favProducts = service.getUserByUsername(uname).getFavourites();
		ResponseEntity<List<Product>> repl = new ResponseEntity<List<Product>>(favProducts, HttpStatus.FOUND);
		return repl;
	}
	
	@GetMapping("/user/delete/{username}")
	public ResponseEntity<User> deleteUser(@PathVariable("username") String uname) {
		service.deleteUserByUsername(uname);
		ResponseEntity<User> reu = new ResponseEntity<User>(HttpStatus.OK);
		return reu;
	}

}
