package com.example.demo.exceptions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(TraineeIdNotFoundException.class)
    ResponseEntity<String> handlerForIdNotFoundException(TraineeIdNotFoundException e){
    	return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String,String>> handlerForArgumentNotValidException(MethodArgumentNotValidException e){
		
		List<FieldError> fieldErrors =e.getFieldErrors();
		Map<String,String> maps= new HashMap<>();
		for(FieldError fe:fieldErrors) {
			String fieldName=fe.getField();
			String errorMsg=fe.getDefaultMessage();
			maps.put(fieldName, errorMsg);
		}
    	return new ResponseEntity<>(maps,HttpStatus.NOT_FOUND);
    }
}
