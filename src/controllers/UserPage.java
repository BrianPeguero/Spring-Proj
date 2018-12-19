package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.User;

@Controller
public class UserPage {
	
	@ModelAttribute("user")
	public User user(String email, String password, int vehicalType, String location) {
		return new User(email, password, vehicalType, location);
	}
	
	@RequestMapping("/userPage")
	public ModelAndView userPage(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("pages/userPage");
		return mav;
	}
	
}
