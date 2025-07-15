package com.ango.port;

import com.ango.domain.ExchangeRate;
import com.ango.domain.client.ExchangeRateClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeRateClientImpl implements ExchangeRateClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExchangeRateProperties exchangeRateProperties;

    @Override
    public ExchangeRate getExchangeRate(String currency) {
        String url = exchangeRateProperties.getUrl();
        try{
            String jsonResponse = restTemplate.getForObject(url, String.class);
            return objectMapper.readValue(jsonResponse,ExchangeRate.class);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }
}
