package com.quotemaker.frontend.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.quotemaker.frontend.model.Product;
import com.quotemaker.frontend.proxies.ProductsServiceProxy;
import com.quotemaker.frontend.response.ProductGeneralResponse;

import feign.FeignException;

@Controller
public class ProductsController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductsServiceProxy productsServiceProxy;

	
	  @GetMapping("/products")
	  public String products(Model m) {
		  ProductGeneralResponse response = productsServiceProxy.list("ASC");
		  m.addAttribute("productsList",response.getProductsList());  
	      return "products";
	  }
	  
	  @GetMapping("/onAddProduct")
	  public ModelAndView onAddProduct() {
		  Product product = new Product();
		  ModelAndView mv = new ModelAndView("addProduct","product", product);
	      return mv;
	  }
	  
	  @PostMapping("/doAddProduct")
	  public ModelAndView doAddProduct(@Valid Product product, BindingResult bindingResult, Model model) {
		  ModelAndView mv = null;
		  if (bindingResult.hasErrors()) {
			  mv = new ModelAndView("addProduct","product", product);
	          return mv;
	      }
		 
		  try {
			  productsServiceProxy.add(product);
			  mv = new ModelAndView("products","product", product);
			  ProductGeneralResponse response = productsServiceProxy.list("ASC");
			  model.addAttribute("productsList",response.getProductsList());
			  model.addAttribute("successfulOperation", true);
			  model.addAttribute("successfulMsg", "The product "+product.getName()+" have been created successfully");
		  } catch  (Exception e) {
			  if (e.getMessage().contains("duplicate key error")) {
				  mv = new ModelAndView("addProduct","product", product);
				  model.addAttribute("existErrors", true);
				  model.addAttribute("errorMsg", "The product "+product.getName()+" already exists");
		          return mv;
			  }
		  }
		  
	      return mv;
	  }
	  
	  @GetMapping("/onEditProduct/{id}")
	  public ModelAndView onEditProduct(@PathVariable String id) {
		  Product product = new Product();
		  ModelAndView mv = new ModelAndView("editProduct","product", product);
		  ProductGeneralResponse response = productsServiceProxy.find(id);
		  product.setIdProduct(response.getProduct().getIdProduct());
		  product.setName(response.getProduct().getName());
		  product.setPrice(String.valueOf(response.getProduct().getPrice()));
	      return mv;
	  }
	  
	  @PostMapping("/doEditProduct")
	  public ModelAndView doEditProduct(@Valid Product product, BindingResult bindingResult, Model model) {
		  ModelAndView mv = null;
		  if (bindingResult.hasErrors()) {
			  mv = new ModelAndView("editProduct","product", product);
	          return mv;
	      }
		 
		  try {
			  productsServiceProxy.edit(product);
			  mv = new ModelAndView("products","product", product);
			  ProductGeneralResponse response = productsServiceProxy.list("ASC");
			  model.addAttribute("productsList",response.getProductsList());
			  model.addAttribute("successfulOperation", true);
			  model.addAttribute("successfulMsg", "The product "+product.getName()+" have been edited successfully");
		  } catch  (Exception e) {
			  if (e.getMessage().contains("duplicate key error")) {
				  mv = new ModelAndView("editProduct","product", product);
				  model.addAttribute("existErrors", true);
				  model.addAttribute("errorMsg", "The product "+product.getName()+" already exists");
		          return mv;
			  }
		  }
		  
	      return mv;
	  }
	
	  @GetMapping("/onDeleteProduct/{id}")
	  public ModelAndView onDelProduct(@PathVariable String id) {
		  Product product = new Product();
		  ModelAndView mv = new ModelAndView("delProduct","product", product);
		  ProductGeneralResponse response = productsServiceProxy.find(id);
		  product.setIdProduct(response.getProduct().getIdProduct());
		  product.setName(response.getProduct().getName());
		  product.setPrice(String.valueOf(response.getProduct().getPrice()));
	      return mv;
	  }
	  
	  @PostMapping(value="/doDeleteProduct", params="action=yes")
	  public ModelAndView doDelProductYes(Product product, BindingResult bindingResult, Model model) {
		  ModelAndView mv = null;
		  
		  productsServiceProxy.delete(String.valueOf(product.getIdProduct()));
		 
		  mv = new ModelAndView("products","product", product);
		  ProductGeneralResponse response = productsServiceProxy.list("ASC");
		  model.addAttribute("productsList",response.getProductsList());
		  model.addAttribute("successfulOperation", true);
		  model.addAttribute("successfulMsg", "The product "+product.getName()+" have been deleted successfully");
	      
		  return mv;
	  }
	  
	  @PostMapping(value="/doDeleteProduct", params="action=no")
	  public ModelAndView doDelProductNo(Product product, BindingResult bindingResult, Model model) {
		  ModelAndView mv = new ModelAndView("products","product", product);
		  ProductGeneralResponse response = productsServiceProxy.list("ASC");
		  model.addAttribute("productsList",response.getProductsList());
		  model.addAttribute("successfulOperation", false);
		  return mv;
	  }
}
