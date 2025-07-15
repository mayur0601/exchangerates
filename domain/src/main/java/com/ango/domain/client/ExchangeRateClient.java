package com.ango.domain.client;

import com.ango.domain.ExchangeRate;


public interface ExchangeRateClient {
    public ExchangeRate getExchangeRate(String currency);
}
