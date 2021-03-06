/**
 * 
 */
package com.demapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demapp.service.UserService;

/**
 * @author muthu_m
 *
 */
@Controller
public class DashboardController 
{
	
	@Autowired
	UserService userService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DashboardController.class);

	@GetMapping(value="/admin/adminHome")
	public ModelAndView home()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userName", userService.getCurrentUser().getName() + " " + userService.getCurrentUser().getLastName());
		LOGGER.info("Reading username from the user object by passing username {} : " + userService.getCurrentUser().getEmail());
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("authorized/admin/home");
		return modelAndView;
	}
	
	@GetMapping(value="/user/userHome")
	public ModelAndView userHome()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userName", userService.getCurrentUser().getName() + " " + userService.getCurrentUser().getLastName());
		LOGGER.info("Reading username from the user object by passing username {} : " + userService.getCurrentUser().getEmail());
		modelAndView.addObject("userMessage","Content Available Only for Users with User Role");
		modelAndView.setViewName("authorized/user/home");
		return modelAndView;
	}
}
