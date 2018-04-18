package com.spring.boot.exceptions;

public class ErrorResponse extends Exception {
	
	private static final long serialVersionUID = 388542559038474351L;
	
	private String errorCode;
	private String message;

	public ErrorResponse(String errorCode, String message) {
		this.message = message;
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

}
