package fr.formation.inti.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.formation.inti.entity.Employee;
import fr.formation.inti.service.EmployeeDto;
import fr.formation.inti.service.IEmployeeService;

@Controller
public class HomeController {
	@Autowired
	private IEmployeeService service;


//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public String home(Model model) {
//		model.addAttribute("message", "Application Spring MVS");
//		model.addAttribute("user", new User("root", "123456", 3));
//
//		return "login";
//	}

	@RequestMapping(value = {"/","/index"})
	public ModelAndView home(HttpServletResponse response) {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String viewRegistrationForm(Model model) {
		EmployeeDto employee= new EmployeeDto();
		model.addAttribute("employee", employee);
		
		return "inscription";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registration(@Valid @ModelAttribute("employee")EmployeeDto employee, BindingResult result) {
		if(result.hasErrors()) {
			if(employee.getTitle().equals("NONE")) {
				result.addError(new FieldError("employee", "title", "Please choose a profession"));
			}
			return "inscription";
		}
//		service.save(employee);
		
		return "newEmployee";
		
	}
	

//	@RequestMapping(value = "/home", method = RequestMethod.POST)
//	public String home2(Model model, @RequestParam ("login") String login, @RequestParam("password") String password) {
//		model.addAttribute("message", "Application SPRING MVC method post :" + login + " " + password);
//		
//		if (password != null && login != null) {
////			User user = userService.findByLoginAndPassword(login, password);
////			model.addAttribute("message", user);
//		}
//		return "welcome";
//	}
	
	
	
	

}
