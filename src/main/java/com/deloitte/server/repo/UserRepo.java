package com.deloitte.server.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.deloitte.server.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	@Query("from User where username=:uname")
	public User findByUsername(String uname);
}
