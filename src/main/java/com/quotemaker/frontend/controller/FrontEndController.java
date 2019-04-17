package com.quotemaker.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FrontEndController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value="/")
    public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
	    modelAndView.setViewName("home");
        return modelAndView;
    }
}
