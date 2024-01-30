package com.soapconsuming.soapdemo.client;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.soapconsuming.soapdemo.entitywsdl.GetCountryRequest;
import com.soapconsuming.soapdemo.entitywsdl.GetCountryResponse;


public class CountryClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountry(String country) {
        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
          .marshalSendAndReceive(request);
        return response;
    }
}