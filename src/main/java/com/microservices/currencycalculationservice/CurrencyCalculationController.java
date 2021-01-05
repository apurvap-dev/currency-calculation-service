package com.microservices.currencycalculationservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyCalculationController {
	
	@Autowired CurrencyCalculationServiceProxy proxy;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyCalculator(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("from", from);
		urlVariables.put("to", to);
		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, urlVariables);
		CurrencyConversionBean response = responseEntity.getBody();
		
		return new CurrencyConversionBean(response.getId(), response.getPort(),from, to,  response.getConversionMultiple(), quantity,quantity.multiply(response.getConversionMultiple()));
	}
	
	@GetMapping("/currency-exchange-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean currencyCalculatorFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from,to);
		
		return new CurrencyConversionBean(response.getId(), response.getPort(),from, to,  response.getConversionMultiple(), quantity,quantity.multiply(response.getConversionMultiple()));
	}

}
