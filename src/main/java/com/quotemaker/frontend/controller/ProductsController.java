package com.quotemaker.frontend.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quotemaker.frontend.model.Product;
import com.quotemaker.frontend.proxies.ProductsServiceProxy;

@Controller
public class ProductsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductsServiceProxy productsServiceProxy;

	  @GetMapping("/products")
	  public String products(Model m) {
		  String response = productsServiceProxy.list("ASC");
		  logger.info("-->"+response);
//		  m.addAttribute("productsList",productsList);  
	      return "products";
	  }
	  
	  @GetMapping("/onAddProduct")
	  public ModelAndView onAddProduct() {
		  Product product = new Product();
		  ModelAndView mv = new ModelAndView("addProduct","product", product);
	      return mv;
	  }
	  
	  @PostMapping("/doAddProduct")
	  public String doAddProduct(Product product) {
		  productsServiceProxy.add(product);
	      return "products";
	  }
	  
	  @PostMapping("/onEditProduct")
	  public String onEditProduct() {
	      return "editProduct";
	  }
	
	
}
