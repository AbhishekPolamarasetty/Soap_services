package com.soapconsuming.soapdemo.clienttest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.soapconsuming.soapdemo.client.CountryClient;
import com.soapconsuming.soapdemo.config.CountryClientConfig;
import com.soapconsuming.soapdemo.entitywsdl.Currency;
import com.soapconsuming.soapdemo.entitywsdl.GetCountryResponse;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = CountryClientConfig.class, loader = AnnotationConfigContextLoader.class)
public class ClientLiveTest {

    @Autowired
    CountryClient client;

    @Test
    public void givenCountryService_whenCountryPoland_thenCapitalIsWarsaw() {
        GetCountryResponse response = client.getCountry("Poland");
        assertEquals("Warsaw", response.getCountry().getCapital());
    }

    @Test
    public void givenCountryService_whenCountrySpain_thenCurrencyEUR() {
        GetCountryResponse response = client.getCountry("Spain");
        assertEquals(Currency.EUR, response.getCountry().getCurrency());
    }
}