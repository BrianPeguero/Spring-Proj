package controllers;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.NoParkingZone;
import models.User;
import models.UserSigningUp;
import services.NoParkingZoneImp;
import services.UserImp;

@Controller
public class SingUp {
	
	@ModelAttribute("userSigningUp")
	public UserSigningUp userSigningUp(String email, String password, Integer vehicalType) {
		return new UserSigningUp(email, password, vehicalType);
	}
	
	@RequestMapping("/signUp")
	public ModelAndView signUpPage() {
		
		Map<Integer, String> vehicalItems = new LinkedHashMap<Integer, String>();
		vehicalItems.put(null, "--Select One--");
		vehicalItems.put(1, "2018 Honda Civic");
		vehicalItems.put(2, "2018 Toyota Camry");
		vehicalItems.put(3, "2018 Toyota Corolla");
		vehicalItems.put(4, "2018 Honda Accord");
		vehicalItems.put(5, "2018 Honda CR-V");
		
		ModelAndView mav = new ModelAndView("pages/signUp");
		
		mav.addObject("vehicalItems", vehicalItems);
		return mav;
	}
	
	@PostMapping(value="/signUp")
	public ModelAndView signingUp(@Valid @ModelAttribute("userSigningUp") UserSigningUp userSigningUp,
																		  BindingResult br) {
		
		Map<Integer, String> vehicalItems = new LinkedHashMap<Integer, String>();
		vehicalItems.put(null, "--Select One--");
		vehicalItems.put(1, "2018 Honda Civic");
		vehicalItems.put(2, "2018 Toyota Camry");
		vehicalItems.put(3, "2018 Toyota Corolla");
		vehicalItems.put(4, "2018 Honda Accord");
		vehicalItems.put(5, "2018 Honda CR-V");
		
		ModelAndView mav = null;
		
		if (br.hasErrors()) {
			mav = new ModelAndView("pages/signUp");
			
			mav.addObject("vehicalItems", vehicalItems);
		} else {
			mav = new ModelAndView("pages/userPage");
			new UserImp().newUser(userSigningUp.getEmail(), userSigningUp.getPassword(), userSigningUp.getVehicalType());
			User dbUser = new UserImp().getUserByEmail(userSigningUp.getEmail());
			List<NoParkingZone> noParkingZoneList = new NoParkingZoneImp().getAllNoParkingZone();
			List<String> listOfAllUserCars = new UserImp().getAllCarLocationsInArea();
			
			mav.addObject("listOfAllUserCars", listOfAllUserCars);
			mav.addObject("user", dbUser);
			mav.addObject("noParkingZoneList", noParkingZoneList);
			
			
		}
		
		return mav;
	}

}
