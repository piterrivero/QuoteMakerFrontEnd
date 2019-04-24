package com.quotemaker.frontend;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.quotemaker.frontend.proxies.ProductsServiceProxy;
import com.quotemaker.frontend.response.ProductGeneralResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServicesTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductsServiceProxy productsServiceProxy;
	
//	@Test
	public void listTest() {
		ProductGeneralResponse response = productsServiceProxy.list("ASC");
		 logger.info("------------------------------>"+response);
	}
	
}
