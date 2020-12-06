package com.hubino.jwt.controllers;

import org.springframework.http.ResponseEntity;

public class ResponseApi {

	private String message;


	public ResponseApi() {
		super();
	}

	public ResponseApi(String message) {
		super();
		this.message = message;
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
