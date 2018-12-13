package controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.User;
import models.UserSigningIn;
import services.UserImp;

@Controller
public class SignIn {
	
	@ModelAttribute("userSignIn")
	public UserSigningIn user(String email, String password) {
		return new UserSigningIn(email, password);
	}
	
	@RequestMapping("/signIn")
	public ModelAndView signInPage() {
		return new ModelAndView("pages/signIn");
	}
	
	@PostMapping(value="/signIn")
	public ModelAndView singingIn(@Valid @ModelAttribute("userSignIn") UserSigningIn user, BindingResult br) {
		ModelAndView mav = null;
		
		if(br.hasErrors()) {
			mav = new ModelAndView("pages/signIn");
		} else {
			if(new UserImp().isValidUser(user)) {
				User dbUser = new UserImp().getUserByEmail(user.getEmail());
				mav = new ModelAndView("pages/userPage");
				mav.addObject("user", dbUser);
			}
		}
		
		return mav;
	}
}
