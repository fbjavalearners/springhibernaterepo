package org.jl.controllers;


import org.jl.UserTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login.htm")
public class LoginController {

	 @Autowired
	 @Qualifier("loginValidator")
	    private Validator loginValidator;
	     
	    @InitBinder
	    private void initBinder(WebDataBinder binder) {
	        binder.setValidator(loginValidator);
	    }
	
	    @RequestMapping(method = RequestMethod.GET)
		public String initForm(Model model){
			UserTo student = new UserTo();
			model.addAttribute("student", student);
			return "student";
		}
		
		@RequestMapping(method = RequestMethod.POST)
		public String submitForm(
			Model model, @Validated UserTo student, BindingResult result) {
			String returnVal = "success";
			if(result.hasErrors()) {
				returnVal = "student";
			} else {
				model.addAttribute("student", student);
			}		
			return returnVal;
		}
	    
}
