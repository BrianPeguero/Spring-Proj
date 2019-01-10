package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import models.NoParkingZone;
import models.User;
import services.NoParkingZoneImp;
import services.UserImp;

@Controller
@SessionAttributes("user")
public class UserPage {
	
	
	@ModelAttribute("user")
	public User user(String email, String password, Integer vehicalType, String location) {
		return new User(email, password, vehicalType, location);
	}
	
	@RequestMapping("/userPage")
	public ModelAndView userPage() {
		ModelAndView mav = new ModelAndView("pages/userPage");
				
		List<NoParkingZone> noParkingZoneList = new NoParkingZoneImp().getAllNoParkingZone();
		List<String> listOfAllUserCars = new UserImp().getAllCarLocationsInArea();
		
		mav.addObject("noParkingZoneList", noParkingZoneList);
		mav.addObject("listOfAllUserCars", listOfAllUserCars);
		
		return mav;
	}
	
	@PostMapping(value = "/capture")
	public ModelAndView capture(@RequestParam("geoCoords") String geoCoords, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("pages/userPage");
		
		List<NoParkingZone> noParkingZoneList = new NoParkingZoneImp().getAllNoParkingZone();
		List<String> listOfAllUserCars = new UserImp().getAllCarLocationsInArea();
		
		User user = (User) request.getSession().getAttribute("sessionUser");
		new UserImp().updateSpot(geoCoords, user.getEmail());
		
		mav.addObject("noParkingZoneList", noParkingZoneList);
		mav.addObject("listOfAllUserCars", listOfAllUserCars);
		
		return mav;
	}
	
	@PostMapping(value = "/release")
	public ModelAndView release(@RequestParam("geoCoords") String geoCoords, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("pages/userPage");
		
		List<NoParkingZone> noParkingZoneList = new NoParkingZoneImp().getAllNoParkingZone();
		List<String> listOfAllUserCars = new UserImp().getAllCarLocationsInArea();
		
		User user = (User) request.getSession().getAttribute("sessionUser");
		new UserImp().updateSpot(geoCoords, user.getEmail());
		
		mav.addObject("noParkingZoneList", noParkingZoneList);
		mav.addObject("listOfAllUserCars", listOfAllUserCars);
		mav.addObject("geoCoords", geoCoords);
		
		return mav;
	}
	
}
