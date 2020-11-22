package com.cg.healthassist.doctorpatient.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
/** This class is to handle Exceptions
 * 
 * @author Manimozhi
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	/** method to handle number format exception */
	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<Object> numberFormatException(NumberFormatException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Invalid input, id should be a number", request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/** method to handle invalid format exception */
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<Object> invalidFormatException(InvalidFormatException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), "Invalid input, id should be a number", request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	/** Method to handle user defined exception patient not found exception */
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<Object> resourceNotFoundException(PatientNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	} 
	/** Method to handle Exception*/  
	
	public ResponseEntity<Object> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage() , request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}    
