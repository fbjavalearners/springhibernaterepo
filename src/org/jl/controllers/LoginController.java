package org.jl.controllers;



import org.jl.service.EmployeeService;
import org.jl.to.EmployeeTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javacodegeeks.snippets.enterprise.model.Student;


@Controller
@RequestMapping("/login")
public class LoginController {

	 @Autowired
	 EmployeeService empService;
	 
	 @Autowired
	 @Qualifier("loginValidator")
	    private Validator loginValidator;
	     
	    @InitBinder
	    private void initBinder(WebDataBinder binder) {
	        binder.setValidator(loginValidator);
	    }
	
	    @RequestMapping(method = RequestMethod.GET)
		public String initForm(Model model){
			EmployeeTo login = new EmployeeTo();
			
			
			model.addAttribute("employeeTo", login);
			return "login";
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public String submitForm(
			Model model, @Validated EmployeeTo login, BindingResult result) {
			System.out.println("form name "+login.getFirstName());
			String returnVal = "homepage";
			if(result.hasErrors()) {
				returnVal = "login";
			} else {
				//Find out if valid user or not 
				EmployeeTo employee = empService.isValidUser(login.getFirstName(), login.getLastName());
				if(employee != null ){
					model.addAttribute("employee", employee);
					returnVal = "homepage";
				}else{
					returnVal = "invalidUser";
				}
				
				
			}		
			return returnVal;
		}
		
		
		@ExceptionHandler(Exception.class)
		public ModelAndView handleAllException(Exception ex) {
	 
			ModelAndView model = new ModelAndView("error");
			model.addObject("errMsg", ex.getMessage());
	 
			return model;
	 
		}
		
		
		
		
		
		
		
	    
}
