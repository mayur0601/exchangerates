package com.ango.domain;

import com.ango.domain.client.ExchangeRateClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExchangeRateServiceTest {

    @Mock
    private ExchangeRateClient exchangeRateClient;

    @InjectMocks
    private ExchangeRateService exchangeRateService;

    @Test
    public void should_return_exchange_rate(){

        String baseCurrency = "USD";
        ExchangeRate expectedExchangeRate = getExchangeRate();

        when(exchangeRateClient.getExchangeRate(baseCurrency)).thenReturn(expectedExchangeRate);

        //ACT
        ExchangeRate actualRate = exchangeRateService.getExchangeRate(baseCurrency);

        //assertion
        assertEquals(expectedExchangeRate.getBaseCurrency(),actualRate.getBaseCurrency());
        assertEquals(expectedExchangeRate.getRates(),actualRate.getRates());


    }

    private ExchangeRate getExchangeRate() {
        Map<String,Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD",1.0);
        exchangeRates.put("AED",3.6);
        exchangeRates.put("IND",80.45);
        return new ExchangeRate("USD",exchangeRates);
    }

}
