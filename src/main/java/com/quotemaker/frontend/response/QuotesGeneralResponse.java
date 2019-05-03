package com.quotemaker.frontend.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.quotemaker.frontend.model.Quote;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class QuotesGeneralResponse {

	private Quote quote;
	private List<Quote> quotesList;
	private int errorCode;
	private String errorMsg;
	private String responsePort;
	
	public QuotesGeneralResponse() {
	}
	
	public Quote getQuote() {
		return quote;
	}
	public void setQuote(Quote quote) {
		this.quote = quote;
	}
	public List<Quote> getQuotesList() {
		return quotesList;
	}
	public void setQuotesList(List<Quote> quotesList) {
		this.quotesList = quotesList;
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
