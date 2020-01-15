package com.deloitte.server.util;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -4719968283395212121L;

	public UserNotFoundException(String message) {
		super(message+": User not found in database");
	}
	
}
