package com.cg.healthassist.doctorpatient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Manimozhi
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PatientNotFoundException extends Exception{	
	private static final long serialVersionUID = 1L;
	public PatientNotFoundException(String s) 
    { 
        super(s); 
    } 
}  
  