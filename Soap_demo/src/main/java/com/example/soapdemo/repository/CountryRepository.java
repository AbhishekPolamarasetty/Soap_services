package com.example.soapdemo.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.soapdemo.entity.Country;
import com.example.soapdemo.entity.Currency;

import jakarta.annotation.PostConstruct;

@Component
public class CountryRepository {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
    	 Country india = new Country();
         india.setName("India");
         india.setCapital("Delhi");
         india.setPopulation(123234);
         india.setCurrency(Currency.EUR);

         // Add the initialized Country object to the countries map
         countries.put(india.getName(), india);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}