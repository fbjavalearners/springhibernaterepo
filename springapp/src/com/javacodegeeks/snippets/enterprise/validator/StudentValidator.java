package com.javacodegeeks.snippets.enterprise.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javacodegeeks.snippets.enterprise.model.Student;

public class StudentValidator implements Validator {

	
	public boolean supports(Class<?> paramClass) {
		return Student.class.equals(paramClass);
	}

	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "valid.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "valid.lastName");
	}
}	
