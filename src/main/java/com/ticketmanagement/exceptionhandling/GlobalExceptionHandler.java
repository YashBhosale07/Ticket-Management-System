package com.ticketmanagement.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<?>handleTouristNotFoundException(TouristNotFoundException exception){
		ErrorMessage error=new ErrorMessage(LocalDateTime.now(),exception.getMessage(),"Tourist not found");
		return new ResponseEntity<ErrorMessage>(error,HttpStatus.BAD_REQUEST);
	}
}
