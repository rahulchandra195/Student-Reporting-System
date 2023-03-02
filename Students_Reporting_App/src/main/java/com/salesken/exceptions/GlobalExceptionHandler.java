package com.salesken.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(StudentException.class)
	public ResponseEntity<ErrorDetails> getStudentException(StudentException sE, WebRequest wR) {

		ErrorDetails errorDetails = new ErrorDetails();

		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(sE.getMessage());
		errorDetails.setDetails(wR.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException mave) {

		ErrorDetails errorDetails = new ErrorDetails();

		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(mave.getMessage()); 
		errorDetails.setDetails(mave.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException nhfe, WebRequest wR) {

		ErrorDetails errorDetails = new ErrorDetails();

		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(nhfe.getMessage());
		errorDetails.setDetails(wR.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> universalExceptionHandler(Exception e, WebRequest wR) {

		ErrorDetails errorDetails = new ErrorDetails();

		errorDetails.setTimeStamp(LocalDateTime.now());
		errorDetails.setMessage(e.getMessage());
		errorDetails.setDetails(wR.getDescription(false));

		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.BAD_REQUEST);

	}

}
