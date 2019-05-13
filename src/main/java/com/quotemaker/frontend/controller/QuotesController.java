package com.quotemaker.frontend.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.quotemaker.frontend.model.Product;
import com.quotemaker.frontend.model.Quote;
import com.quotemaker.frontend.model.QuoteDetail;
import com.quotemaker.frontend.proxies.ProductsServiceProxy;
import com.quotemaker.frontend.proxies.QuotesServiceProxy;
import com.quotemaker.frontend.response.ProductGeneralResponse;
import com.quotemaker.frontend.response.QuotesGeneralResponse;

@Controller
public class QuotesController {

	  private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	  @Autowired
	  private QuotesServiceProxy quotesServiceProxy;
	  @Autowired
	  private ProductsServiceProxy productsServiceProxy;
	  
	  private List<Product> productsList;

	
	  @GetMapping("/quotes")
	  public String quotes(Model m) {
		  QuotesGeneralResponse response = quotesServiceProxy.list("ASC");
		  m.addAttribute("quotesList",response.getQuotesList());  
	      return "quotes";
	  }
	  
	  @GetMapping("/onAddQuote")
	  public ModelAndView onAddQuote(Model model) {
		  Quote quote = new Quote();
		  
		  ProductGeneralResponse productGeneralResponse = productsServiceProxy.list("ASC");
		  productsList = productGeneralResponse.getProductsList();
		  model.addAttribute("productsList",productsList);
		  
		  ModelAndView mv = new ModelAndView("addQuote","quote", quote);
	      return mv;
	  }
	  
	  @PostMapping("/doAddQuote")
	  public ModelAndView doAddQuote(@Valid Quote quote, BindingResult bindingResult, Model model) {
		  ModelAndView mv = null;
		  
		  if (quote.getDetailProductName() != null && !quote.getDetailProductName().equals("")) {
			  mv = new ModelAndView("addQuote","quote", quote);
			  QuoteDetail qd = new QuoteDetail();
			  qd.setProduct(quote.getDetailProductName());
			  qd.setQuantity(quote.getDetailProductQuantity());
			  quote.getQuotes().add(qd);
			  
			  quote.setDetailProductName(null);
			  quote.setDetailProductQuantity(0);
			  return mv;
		  } else {
			  if (bindingResult.hasErrors()) {
				  mv = new ModelAndView("addQuote","quote", quote);
		          return mv;
		      }
			  
			  List<QuoteDetail> list = new ArrayList<QuoteDetail>();
			  QuoteDetail qd = new QuoteDetail();
			  qd.setProduct("aaa");
			  qd.setQuantity(2);
			  list.add(qd);
			  quote.setQuotes(list);
			 
			  QuotesGeneralResponse resp = quotesServiceProxy.add(quote);
			  
			  mv = new ModelAndView("quotes","quote", quote);
			  QuotesGeneralResponse response = quotesServiceProxy.list("ASC");
			  model.addAttribute("quotesList",response.getQuotesList());
			  model.addAttribute("successfulOperation", true);
			  model.addAttribute("successfulMsg", "The quote "+resp.getQuote().getIdQuote()+" have been created successfully");
		  }
	      return mv;
	  }
	  
	  @GetMapping("/onEditQuote/{id}")
	  public ModelAndView onEditQuote(@PathVariable String id) {
		  Quote quote = new Quote();
		  ModelAndView mv = new ModelAndView("editQuote","quote", quote);
		  QuotesGeneralResponse response = quotesServiceProxy.find(id);
		  quote.setIdQuote(response.getQuote().getIdQuote());
		  quote.setCustomerName(response.getQuote().getCustomerName());
		  quote.setCustomerFiscalNumber(String.valueOf(response.getQuote().getCustomerFiscalNumber()));
	      return mv;
	  }
	  
	  @PostMapping("/doEditQuote")
	  public ModelAndView doEditQuote(@Valid Quote quote, BindingResult bindingResult, Model model) {
		  ModelAndView mv = null;
		  if (bindingResult.hasErrors()) {
			  mv = new ModelAndView("editQuote","quote", quote);
	          return mv;
	      }
		 
		  quotesServiceProxy.edit(quote);
		  mv = new ModelAndView("quotes","quote", quote);
		  QuotesGeneralResponse response = quotesServiceProxy.list("ASC");
		  model.addAttribute("quotesList",response.getQuotesList());
		  model.addAttribute("successfulOperation", true);
		  model.addAttribute("successfulMsg", "The quote "+quote.getIdQuote()+" have been edited successfully");
		  
	      return mv;
	  }
	
	  @GetMapping("/onDeleteQuote/{id}")
	  public ModelAndView onDelQuote(@PathVariable String id) {
		  Quote quote = new Quote();
		  ModelAndView mv = new ModelAndView("delQuote","quote", quote);
		  QuotesGeneralResponse response = quotesServiceProxy.find(id);
		  quote.setIdQuote(response.getQuote().getIdQuote());
		  quote.setCustomerName(response.getQuote().getCustomerName());
		  quote.setCustomerFiscalNumber(String.valueOf(response.getQuote().getCustomerFiscalNumber()));
	      return mv;
	  }
	  
	  @PostMapping(value="/doDeleteQuote", params="action=yes")
	  public ModelAndView doDelQuoteYes(Quote quote, BindingResult bindingResult, Model model) {
		  ModelAndView mv = null;
		  quotesServiceProxy.delete(String.valueOf(quote.getIdQuote()));
		  mv = new ModelAndView("quotes","quote", quote);
		  QuotesGeneralResponse response = quotesServiceProxy.list("ASC");
		  model.addAttribute("quotesList",response.getQuotesList());
		  model.addAttribute("successfulOperation", true);
		  model.addAttribute("successfulMsg", "The quote "+quote.getIdQuote()+" have been deleted successfully");
	      
		  return mv;
	  }
	  
	  @PostMapping(value="/doDeleteQuote", params="action=no")
	  public ModelAndView doDelQuoteNo(Quote quote, BindingResult bindingResult, Model model) {
		  ModelAndView mv = new ModelAndView("quotes","quote", quote);
		  QuotesGeneralResponse response = quotesServiceProxy.list("ASC");
		  model.addAttribute("quotesList",response.getQuotesList());
		  model.addAttribute("successfulOperation", false);
		  return mv;
	  }

	  
	public List<Product> getProductsList() {
		return productsList;
	}

	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}
	  
	
}
