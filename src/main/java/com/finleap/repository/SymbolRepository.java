package com.finleap.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SymbolRepository {

    private Map<String, String> symbolMap = new HashMap<>();

    public void put(String symbol,String value){
        symbolMap.put(symbol,value);
    }

    public String get(String symbol){
       return symbolMap.get(symbol);
    }
}
