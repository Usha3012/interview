package com.finleap.calculator;

import com.finleap.converter.RomanToDecimalConverter;
import com.finleap.repository.CreditsRepository;
import com.finleap.repository.SymbolRepository;

import java.math.BigDecimal;
import java.util.Arrays;

public class CreditCalculator implements Calculator {
    private final String PIVOT = "is";
    private SymbolRepository symbolRepository;
    private CreditsRepository creditsRepository;
    public CreditCalculator(SymbolRepository symbolRepository,CreditsRepository creditsRepository){
        this.symbolRepository = symbolRepository;
        this.creditsRepository = creditsRepository;
    }
    @Override
    public void calculateAndPut(String symbol) {
        String[] splittedString = symbol.split(" ");
        int position = findPivotPosition(splittedString);
        calculateAndPut(splittedString,position);
    }

    private void calculateAndPut(String[] splittedString, int position){
        BigDecimal totalValue = new BigDecimal(splittedString[position+1]);
        BigDecimal symbolValue = getTotalSymbolValue(Arrays.copyOfRange(splittedString,0,position));
        creditsRepository.put(splittedString[position-1],totalValue.divideToIntegralValue(symbolValue));
    }

    private BigDecimal getTotalSymbolValue(String[] keys) {
        String roman="";
        for(String s:keys){
            String symbol= symbolRepository.get(s);
            if(symbol!=null){
               roman+=symbol;
            }
        }
        return RomanToDecimalConverter.toDecimal(roman);
    }

    private int findPivotPosition(String[] splittedInput) {
        for(int i =0;i<splittedInput.length;i++){
            if(splittedInput[i].equals(PIVOT)){
                return i;
            }
        }
        return -1;
    }
}
