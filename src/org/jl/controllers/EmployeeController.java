package org.jl.controllers;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.jl.json.JsonResponse;
import org.jl.service.EmployeeService;
import org.jl.to.EmployeeTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javacodegeeks.snippets.enterprise.model.Student;


@Controller

public class EmployeeController {

	 @Autowired
	 EmployeeService empService;
	 
	
	 @RequestMapping(value = "/listemployees", method = RequestMethod.GET)
	    public String listEmployees(Model model) {
	       
	        model.addAttribute("allEmployees", empService.getAllEmployees());
	        return "allemployees";
	    }
		
	 @RequestMapping(value = "/deleteemployee/{id}", method = RequestMethod.GET)
	    public String deleteEmployee(@PathVariable("id") int id) {
	     System.out.println("entered delete "+id);
		 empService.deleteEmployee(id);
		 return "redirect:/listemployees.htm";
	       
	    }
	 @RequestMapping(value = "/editemployeeform/{id}", method = RequestMethod.GET)
	    public ModelAndView editEmployee(@PathVariable("id") int id) {
		 ModelAndView modelAndView = new ModelAndView("editemployeeform");
	     EmployeeTo emp = empService.getEmployee(id);
	     System.out.println("empid "+emp.getEmail()+" "+emp.getHireDate());

		 modelAndView.addObject("employee",emp);
		 return modelAndView;
	       
	    }
	 @RequestMapping(value = "/editemployeeform", method = RequestMethod.POST)
	    public String editEmployeePost(@ModelAttribute EmployeeTo emp) {
		
	     empService.updateEmployee(emp);
	     return "redirect:/listemployees.htm";
	       
	    }
	 
	 
	 @RequestMapping(value= "/addemployee", method = RequestMethod.POST)
	    public String addPerson(@ModelAttribute("employee") EmployeeTo emp){
	         
	       
		 empService.addEmployee(emp);
	     return "redirect:/listemployees.htm";
	         
	    }
	 
	 @RequestMapping(value= "/addemployeeform", method = RequestMethod.GET)
	    public String addEmployeeForm(Model m){
	         EmployeeTo emp = new EmployeeTo();
	         m.addAttribute("employee",emp);
	         return "employeeform";
	        
	         
	    }
	
	 @InitBinder
	    public void initBinder(WebDataBinder webDataBinder) {
	             SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	             dateFormat.setLenient(false);
	             webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	         }
		
	 @RequestMapping(value="/validuser")
	 public @ResponseBody
	     
	
	 JsonResponse helloAjaxTest(@ModelAttribute EmployeeTo emp) {
	     EmployeeTo emps = empService.isValidUser(emp.getFirstName(), emp.getLastName()); 
	     System.out.println("emp "+emp.getFirstName()+emp.getLastName());
	     JsonResponse js = new JsonResponse();
	     if(emps !=null && emps.getEmployeeId() !=0 ){
	   
	        js.setRespMsg("User already exists ");
	     }else{
	    	js.setRespMsg("");
	     }
	        return js;
	    }
		
	 @RequestMapping(value="/checkemail")
	 public @ResponseBody
	     
	
	 JsonResponse checkEmail(@ModelAttribute EmployeeTo emp) {
	     EmployeeTo emps = empService.emailAlreadyExists(emp); 
	
	     JsonResponse js = new JsonResponse();
	     if(emps !=null && emps.getEmployeeId() !=0 ){
	   
	        js.setRespMsg("Email already exists ");
	     }else{
	    	js.setRespMsg("");
	     }
	        return js;
	    }
		
	 @RequestMapping(value="/getJobIds")
	 public @ResponseBody
	     
	
	 List getJobIds(@RequestParam("term") String name) {
	    return empService.getJobIds(name);
	 }
	    
}
