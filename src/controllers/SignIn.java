package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.NoParkingZone;
import models.User;
import models.UserSigningIn;
import services.NoParkingZoneImp;
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
	public ModelAndView singingIn(@Valid @ModelAttribute("userSignIn") UserSigningIn user, 
																	   BindingResult br,
																	   HttpServletRequest request,
																	   HttpServletResponse response) {
		ModelAndView mav = null;
		
		if(br.hasErrors()) {
			mav = new ModelAndView("pages/signIn");
		} else {
			User dbUser = new UserImp().getUserByEmail(user.getEmail());
			if(dbUser.getEmail().equals(user.getEmail()) && dbUser.getPassword().equals(user.getPassword())) {
				mav = new ModelAndView("pages/userPage");
				
				request.getSession().setAttribute("sessionUser", dbUser);
				
				List<NoParkingZone> noParkingZoneList = new NoParkingZoneImp().getAllNoParkingZone();
				List<String> listOfAllUserCars = new UserImp().getAllCarLocationsInArea();
				
				mav.addObject("noParkingZoneList", noParkingZoneList);
				mav.addObject("listOfAllUserCars", listOfAllUserCars);
				mav.addObject("sessionUser", dbUser);
				
			} else {
				mav = new ModelAndView("pages/signIn");
			}
		}
		
		return mav;
	}
	
}
