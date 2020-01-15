package com.deloitte.server.util;

import java.time.LocalDate;

public class UserErrorResponse {
	private LocalDate timestamp;
	private String message;
	private String uri;

	public UserErrorResponse(LocalDate timestamp, String message, String uri) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.uri = uri;
	}

	public UserErrorResponse() {
		super();
	}

	public LocalDate getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDate timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "UserErrorResponse [timestamp=" + timestamp + ", message=" + message + ", uri=" + uri + "]";
	}

}
