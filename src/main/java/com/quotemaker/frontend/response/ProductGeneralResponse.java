package com.quotemaker.frontend.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.quotemaker.frontend.model.Product;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductGeneralResponse {

	private Product product;
	private List<Product> productsList;
	private int errorCode;
	private String errorMsg;
	private String responsePort;
	
	public ProductGeneralResponse() {
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public List<Product> getProductsList() {
		return productsList;
	}
	public void setProductsList(List<Product> productsList) {
		this.productsList = productsList;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getResponsePort() {
		return responsePort;
	}
	public void setResponsePort(String responsePort) {
		this.responsePort = responsePort;
	}
	
}
