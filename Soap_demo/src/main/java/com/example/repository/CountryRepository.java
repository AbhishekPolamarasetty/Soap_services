package com.example.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.entity.Country;

import jakarta.annotation.PostConstruct;

@Component
public class CountryRepository {
	 private static final Map<String, Country> countries = new HashMap<>();

	    @PostConstruct
	    public void initData() {
	        // initialize countries map
	    }

	    public Country findCountry(String name) {
	        return countries.get(name);
	    }
}
