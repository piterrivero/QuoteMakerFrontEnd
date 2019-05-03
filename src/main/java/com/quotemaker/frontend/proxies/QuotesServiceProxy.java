package com.quotemaker.frontend.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quotemaker.frontend.model.Quote;
import com.quotemaker.frontend.response.QuotesGeneralResponse;

@FeignClient(name="quote-maker-quotes-service")
@RibbonClient(name="quote-maker-quotes-service")
public interface QuotesServiceProxy {

	@GetMapping("/quotes/test")
	public String test();
	
	@RequestMapping(value = "/quotes/list")
	public QuotesGeneralResponse list(@RequestParam String order);

	@PostMapping(value = "/quotes/add")
	public QuotesGeneralResponse add(@RequestBody Quote quote);
	
	@GetMapping(value = "/quotes/find")
	public QuotesGeneralResponse find(@RequestParam String id);
	
	@PostMapping(value = "/quotes/edit")
	public QuotesGeneralResponse edit(@RequestBody Quote quote);
	
	@GetMapping(value = "/quotes/delete")
	public QuotesGeneralResponse delete(@RequestParam String id);
	
}
