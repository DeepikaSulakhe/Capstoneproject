package com.eatza.deliverservice.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	private static final Logger logger = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<Object> exception(UnauthorizedException exception) {
		logger.debug("Handling UnauthorizedException");
		 return new ResponseEntity<>("Invalid Credentials", HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(DeliveryException.class)
	public ResponseEntity<Object> exception(DeliveryException exception) {
		logger.debug("Handling DeliverException");
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ItemDeliverdException.class)
	public ResponseEntity<Object> exception(ItemDeliverdException exception) {
		logger.debug("Handling Item delivered Exception");
		 return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
