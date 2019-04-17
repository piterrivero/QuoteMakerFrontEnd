package com.quotemaker.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class QuotesController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	  @RequestMapping(value="/quotes")
	  public ModelAndView groups() {
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("quotes");
	      return modelAndView;
	  }
	  
	  @RequestMapping(value="/onAddQuote")
	  public ModelAndView onAddGroup() {
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("addQuote");
	      return modelAndView;
	  }
	  
	  @RequestMapping(value="/onEditQuote")
	  public ModelAndView onEditGroup() {
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("editQuote");
	      return modelAndView;
	  }
	
	
}
