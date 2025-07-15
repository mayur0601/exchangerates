package com.ango.domain;

import com.ango.domain.client.ExchangeRateClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExchangeRateService {

    private final ExchangeRateClient exchangeRateClient;

    @Autowired
    public ExchangeRateService(ExchangeRateClient exchangeRateClient) {
        this.exchangeRateClient = exchangeRateClient;
    }

    public ExchangeRate getExchangeRate(String baseCurrency) {
        return exchangeRateClient.getExchangeRate(baseCurrency);
    }


}
