package org.jl.validators;

import org.jl.to.EmployeeTo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
 


 
@Component
public class LoginValidator implements Validator {
     
   
 
    @Override
    public boolean supports(Class<?> clazz) {
        return EmployeeTo.class.isAssignableFrom(clazz);
    }
 
    @Override
    public void validate(Object target, Errors errors) {
        
         
      
         
        ValidationUtils.rejectIfEmpty(errors, "firstName", "firstname.empty");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "lastname.empty");
       
 
    }
 
}