package com.quotemaker.frontend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ProductsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	  @RequestMapping(value="/products")
	  public ModelAndView products() {
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("products");
	      return modelAndView;
	  }
	  
	  @RequestMapping(value="/onAddProduct")
	  public ModelAndView onAddProduct() {
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("addProduct");
	      return modelAndView;
	  }
	  
	  @RequestMapping(value="/onEditProduct")
	  public ModelAndView onEditProduct() {
		  ModelAndView modelAndView = new ModelAndView();
		  modelAndView.setViewName("editProduct");
	      return modelAndView;
	  }
	
	
}
