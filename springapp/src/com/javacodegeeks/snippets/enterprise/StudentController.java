package com.javacodegeeks.snippets.enterprise;

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

import com.javacodegeeks.snippets.enterprise.model.Student;

@Controller
@RequestMapping("/student.htm")
public class StudentController {

    @Autowired
    @Qualifier("studentValidator")
    private Validator validator;
    
    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);
    }
	
	@RequestMapping(method = RequestMethod.GET)
	public String initForm(Model model){
		Student student = new Student();
		model.addAttribute("student", student);
		return "student";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(
		Model model, @Validated Student student, BindingResult result) {
		String returnVal = "success";
		if(result.hasErrors()) {
			returnVal = "student";
		} else {
			model.addAttribute("student", student);
		}		
		return returnVal;
	}

}	
