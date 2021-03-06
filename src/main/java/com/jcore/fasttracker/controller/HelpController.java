package com.jcore.fasttracker.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelpController {

	/**
	 * Display the help page
	 * 
	 * @param httpRequest
	 * @param model
	 * @return
	 */
    @RequestMapping(value = "/help", method = RequestMethod.GET)
    public String help(HttpServletRequest httpRequest, Model model) {
        return "/help";
    }
}