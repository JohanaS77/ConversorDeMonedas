package com.aluracursos.conversor;

import java.util.Map;

public class ConversionResponse {
    private String result;
    private Map<String, Double> conversionRates;

    public Double getConversionRate(String currencyCode) {
        return conversionRates.get(currencyCode);
    }
    public String getResult() {
        return result;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }
}




