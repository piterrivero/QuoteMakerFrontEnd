package com.quotemaker.frontend.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class Quote {

	private long idQuote;
	
	@NotEmpty(message="Please enter the customer name")
	private String customerName;
	
	@NotEmpty(message="Please enter the customer fiscal number")
	private String customerFiscalNumber;
	
	private String quoteDate;

	private List<QuoteDetail> quotes;
	
	private double totalPriceWithoutIVA;
	
	private double iva;
	
	private double total;
	
	private String detailProductName;
	
	private int detailProductQuantity;
	
	public Quote() {
	}
	
	public long getIdQuote() {
		return idQuote;
	}

	public void setIdQuote(long idQuote) {
		this.idQuote = idQuote;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerFiscalNumber() {
		return customerFiscalNumber;
	}

	public void setCustomerFiscalNumber(String customerFiscalNumber) {
		this.customerFiscalNumber = customerFiscalNumber;
	}

	public String getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(String quoteDate) {
		this.quoteDate = quoteDate;
	}

	public List<QuoteDetail> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<QuoteDetail> quotes) {
		this.quotes = quotes;
	}

	public double getTotalPriceWithoutIVA() {
		return totalPriceWithoutIVA;
	}

	public void setTotalPriceWithoutIVA(double totalPriceWithoutIVA) {
		this.totalPriceWithoutIVA = totalPriceWithoutIVA;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDetailProductName() {
		return detailProductName;
	}

	public void setDetailProductName(String detailProductName) {
		this.detailProductName = detailProductName;
	}

	public int getDetailProductQuantity() {
		return detailProductQuantity;
	}

	public void setDetailProductQuantity(int detailProductQuantity) {
		this.detailProductQuantity = detailProductQuantity;
	}
}
