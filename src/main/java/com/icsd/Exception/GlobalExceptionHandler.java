package com.icsd.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.icsd.common.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest)
	{
		return new ResponseEntity<ApiResponse>(new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(),ex.getMessage()), HttpStatus.BAD_REQUEST);
	}
}
