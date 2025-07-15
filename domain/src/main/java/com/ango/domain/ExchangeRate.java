package com.ango.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.Map;

public class ExchangeRate {

    @JsonProperty("base")
    private String baseCurrency;

    @JsonProperty("rates")
    private Map<String,Double> rates;

    @JsonProperty("last_updated")
    private Date last_updated;

    public ExchangeRate(String baseCurrency, Map<String, Double> rates) {
        this.baseCurrency = baseCurrency;
        this.rates = rates;
        this.last_updated = new Date();
    }

    public ExchangeRate() {
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public Date getLast_updated() {
        return last_updated;
    }

    public void setLast_updated(Date last_updated) {
        this.last_updated = last_updated;
    }
}
