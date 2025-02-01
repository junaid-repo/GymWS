package com.gympro.gplans.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> invalidRequest(MethodArgumentNotValidException ex){
		
		
		Map<String, String> errMap=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach((obj->
		errMap.put(String.valueOf(obj.getField()), obj.getDefaultMessage())));
		return errMap;
	}

}
