package com.microservices.currencycalculationservice;

import java.math.BigDecimal;


public class CurrencyConversionBean {

	private int id;
	private int port;
	private String from;
	private String to ;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal calculatedValue;
	
	public CurrencyConversionBean() {
		
	}
	
	public CurrencyConversionBean(int id, int port, String from, String to, BigDecimal conversionMultiple,
			BigDecimal quantity, BigDecimal calculatedValue) {
		super();
		this.id = id;
		this.port = port;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.calculatedValue = calculatedValue;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getCalculatedValue() {
		return calculatedValue;
	}
	public void setCalculatedValue(BigDecimal calculatedValue) {
		this.calculatedValue = calculatedValue;
	}
	
	


	
}
