package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import models.User;

@Controller
@SessionAttributes("user")
public class UserPage {
	
	@ModelAttribute("user")
	public User user(String email, String password, int vehicalType) {
		return new User(email, password, vehicalType);
	}
	
	@RequestMapping("/userPage")
	public ModelAndView userPage(@ModelAttribute("user") User user) {
		ModelAndView mav = new ModelAndView("pages/userPage");
		return mav;
	}
	
}
