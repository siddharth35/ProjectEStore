package com.deloitte.server.util;

public class UserAlreadyExistException extends RuntimeException {
	private static final long serialVersionUID = -73747918646508042L;

	public UserAlreadyExistException(String message) {
		super(message+": Username already taken");
	}
	
}
