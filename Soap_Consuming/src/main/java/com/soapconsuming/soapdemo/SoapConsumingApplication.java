package com.soapconsuming.soapdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.soapconsuming.soapdemo.client.CountryClient;
import com.soapconsuming.soapdemo.entitywsdl.GetCountryResponse;

@SpringBootApplication
public class SoapConsumingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoapConsumingApplication.class, args);
	}
	  @Bean
	  CommandLineRunner lookup(CountryClient countryClient) {
	    return args -> {
	      String country = "Spain";

	      if (args.length > 0) {
	        country = args[0];
	      }
	      GetCountryResponse response = countryClient.getCountry(country);
	      System.err.println(response.getCountry().getCurrency());
	    };
	  }

	}

