package com.deloitte.server.controller;

import java.time.LocalDate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.deloitte.server.util.UserAlreadyExistException;
import com.deloitte.server.util.UserErrorResponse;
import com.deloitte.server.util.UserNotFoundException;

@RestController
@ControllerAdvice
public class UserErrorController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<UserErrorResponse> allErrorHandler(Exception e, WebRequest wreq) {
		UserErrorResponse uer = new UserErrorResponse(LocalDate.now(), e.getMessage(), wreq.getDescription(false));
		ResponseEntity<UserErrorResponse> reuer = new ResponseEntity<UserErrorResponse>(uer, HttpStatus.BAD_REQUEST);
		return reuer;
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<UserErrorResponse> userNotFoundHandler(UserNotFoundException unfe, WebRequest wreq) {
		UserErrorResponse uer = new UserErrorResponse(LocalDate.now(), unfe.getMessage(), wreq.getDescription(false));
		ResponseEntity<UserErrorResponse> reuer = new ResponseEntity<UserErrorResponse>(uer, HttpStatus.NOT_FOUND);
		return reuer;
	}

	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<UserErrorResponse> userAlreadyExistsHandler(UserAlreadyExistException uaee, WebRequest wreq) {
		UserErrorResponse uer = new UserErrorResponse(LocalDate.now(), uaee.getMessage(), wreq.getDescription(false));
		ResponseEntity<UserErrorResponse> reuer = new ResponseEntity<UserErrorResponse>(uer, HttpStatus.CONFLICT);
		return reuer;
	}
}
