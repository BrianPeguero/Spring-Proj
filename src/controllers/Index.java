package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import models.NoParkingZone;
import services.NoParkingZoneImp;
import services.UserImp;

@Controller
public class Index {
	
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index");
		
		List<NoParkingZone> noParkingZoneList = new NoParkingZoneImp().getAllNoParkingZone();
		List<String> listOfAllUserCars = new UserImp().getAllCarLocationsInArea();
		
		mav.addObject("noParkingZoneList", noParkingZoneList);
		mav.addObject("listOfAllUserCars", listOfAllUserCars);
		
		return mav;
	}
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("index");
		
		List<NoParkingZone> noParkingZoneList = new NoParkingZoneImp().getAllNoParkingZone();
		List<String> listOfAllUserCars = new UserImp().getAllCarLocationsInArea();
		
		mav.addObject("noParkingZoneList", noParkingZoneList);
		mav.addObject("listOfAllUserCars", listOfAllUserCars);
		
		return mav;
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