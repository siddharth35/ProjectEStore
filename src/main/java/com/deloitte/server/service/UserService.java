package com.deloitte.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.server.model.Product;
import com.deloitte.server.model.User;
import com.deloitte.server.repo.UserRepo;
import com.deloitte.server.util.UserAlreadyExistException;
import com.deloitte.server.util.UserNotFoundException;

@Service
public class UserService {
	@Autowired
	UserRepo repo;

	public User getUserByUsername(String uname) {
		User user = repo.findByUsername(uname);
		if(user==null) {
			throw new UserNotFoundException("Cannot find: "+uname);
		}
		return user;
	}
	
	public User addUser(User user) {
		if(repo.findByUsername(user.getUsername())!=null) {
			throw new UserAlreadyExistException("Username:"+user.getUsername());
		}
		return repo.save(user);
	}
	
	public List<User> getAllUsers() {
		List<User> allUsers = repo.findAll();
		return allUsers;
	}
	
	public void deleteUserById(Long uid) {
		repo.deleteById(uid);
	}
	
	public User updateUser(User user) {
		User usr = repo.findByUsername(user.getUsername());
		if(usr==null) {
			throw new UserNotFoundException("Unable to update: "+user.getUsername());
		}
		usr = repo.getOne(usr.getId());
		usr.setPassword(user.getPassword());
		usr.setCountry(user.getCountry());
		usr.setIsAdmin(user.getIsAdmin());
		return user;
	}
	
	public boolean addToFavourite(String uname, Product product) {
		User user = getUserByUsername(uname);
		boolean added = user.getFavourites().add(product);
		return added;
	}
	
	
}
