package com.gs.rest.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.gs.rest.user.UserNotFoundException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException ex, WebRequest request) 
			throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(exceptionResponse ,HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@SuppressWarnings("unchecked")
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request) 
			throws Exception {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		ResponseEntity<ExceptionResponse> responseEntity = new ResponseEntity<ExceptionResponse>(exceptionResponse ,HttpStatus.INTERNAL_SERVER_ERROR);
		return responseEntity;
	}
	
	/**
	 * Customize the response for MethodArgumentNotValidException.
	 * <p>This method delegates to {@link #handleExceptionInternal}.
	 * @param ex the exception
	 * @param headers the headers to be written to the response
	 * @param status the selected response status
	 * @param request the current request
	 * @return a {@code ResponseEntity} instance
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exceptionResponse = 
					new ExceptionResponse(new Date(),"validation failed", ex.getBindingResult().toString());
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(exceptionResponse ,HttpStatus.BAD_REQUEST);
		return responseEntity;
	}

}
