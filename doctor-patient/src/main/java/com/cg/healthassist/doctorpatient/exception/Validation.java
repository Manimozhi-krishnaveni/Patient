package com.cg.healthassist.doctorpatient.exception;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/** This class is to validate 
 * 
 * @author Manimozhi
 *
 */
public class Validation {
	/** This method is to validate patient id and medical record Id*/
	public boolean validatePatientId(Integer patientId) {
		String regex="^[0-9]";
		Pattern pattern=Pattern.compile(regex);
		Matcher matcher=null;
		matcher =pattern.matcher(String.valueOf(patientId));
		return matcher.matches();
	}  

}   

