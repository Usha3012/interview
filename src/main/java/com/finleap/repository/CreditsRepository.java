package com.finleap.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CreditsRepository {

    private Map<String, BigDecimal> symbolMap = new HashMap<>();

    public void put(String symbol,BigDecimal value){
        symbolMap.put(symbol,value);
    }

    public BigDecimal get(String symbol){
       return symbolMap.get(symbol);
    }
}
