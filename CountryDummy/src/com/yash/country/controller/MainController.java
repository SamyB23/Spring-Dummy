package com.yash.country.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.yash.country.dao.CountryDAO;
import com.yash.country.model.Country;

@Controller
public class MainController {
	
	@Autowired
	private CountryDAO countryDAO;

	@RequestMapping(value = "/")
	public ModelAndView countryList(ModelAndView model) {
		List<Country> countryList = countryDAO.list();
		
		model.addObject("countryList", countryList);
		model.setViewName("index");
		
		return model;
	}
	
	@RequestMapping(value = "/newCountry", method = RequestMethod.GET)
	public ModelAndView newCountry(ModelAndView model) {
		Country newCountry = new Country();
		
		model.addObject("country", newCountry);
		model.setViewName("country_form");
		
		return model;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveCountry(@ModelAttribute Country country) {
		if(country.getId() == null) {
			countryDAO.save(country);
		}
		else {
			countryDAO.update(country);
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editCountry(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		Country country = countryDAO.get(id);
		
		ModelAndView model = new ModelAndView("country_form");
		
		model.addObject("country", country);

		return model;
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteCountry(@RequestParam Integer id) {
		countryDAO.delete(id);
		
		return new ModelAndView("redirect:/");
	}
}
