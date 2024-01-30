package com.soapproducing.soapdemo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soapproducing.soapdemo.entity.GetCountryRequest;
import com.soapproducing.soapdemo.entity.GetCountryResponse;
import com.soapproducing.soapdemo.repository.CountryRepository;

@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://www.com/soapproducing/soapdemo/entity";
	
	@Autowired
	private CountryRepository countryRepository;

	
//	public CountryEndpoint(CountryRepository countryRepository) {
//		this.countryRepository = countryRepository;
//	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
	@ResponsePayload
	public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
		GetCountryResponse response = new GetCountryResponse();
		response.setCountry(countryRepository.findCountry(request.getName()));

		return response;
	}
}