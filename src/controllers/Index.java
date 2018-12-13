package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Index {
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/about")
	public ModelAndView about() {
		return new ModelAndView("pages/about");
	}
	
	@RequestMapping("/contact")
	public ModelAndView contact() {
		return new ModelAndView("pages/contact");
	}
	
}