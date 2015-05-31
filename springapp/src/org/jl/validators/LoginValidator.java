package org.jl.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 
import org.jl.UserTo;
 

public class LoginValidator implements Validator {
     
   
 
    @Override
    public boolean supports(Class<?> clazz) {
        return UserTo.class.isAssignableFrom(clazz);
    }
 
    @Override
    public void validate(Object target, Errors errors) {
       
         
      
         
        ValidationUtils.rejectIfEmpty(errors, "first_name", "firstname.empty");
        ValidationUtils.rejectIfEmpty(errors, "last_name", "lastname.empty");
       
 
    }
 
}