package com.spring.boot.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(ErrorResponse.class)
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<?> HandleException(ErrorResponse e) {
		
		return new ResponseEntity<Object>(e.getMessage() + "\n", HttpStatus.BAD_REQUEST);
	}

}
