package com.ango.rest;

import com.ango.domain.ExchangeRate;
import com.ango.domain.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeRateRestController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @GetMapping("/latest/{currency}")
    public ExchangeRate getData(@PathVariable String currency){
        return exchangeRateService.getExchangeRate(currency);
    }

}
