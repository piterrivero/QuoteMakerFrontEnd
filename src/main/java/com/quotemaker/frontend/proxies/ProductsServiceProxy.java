package com.quotemaker.frontend.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="quote-maker-products-service")
@RibbonClient(name="quote-maker-products-service")
public interface ProductsServiceProxy {

	@GetMapping("/products/test")
	public String test();
	
	@RequestMapping(value = "/products/list?order={order}")
	public String list(@RequestParam String order);
	
}
