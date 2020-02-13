package com.finleap.calculator;

import com.finleap.converter.RomanToDecimalConverter;
import com.finleap.repository.SymbolRepository;

public class SymbolCalculator implements Calculator {
    private final String PIVOT = "is";
    private SymbolRepository symbolRepository = new SymbolRepository();

    public SymbolCalculator(SymbolRepository symbolRepository){
        this.symbolRepository = symbolRepository;
    }
    @Override
    public void calculateAndPut(String symbol) {
           String[] splittedString = symbol.split(" ");
           int position = findPivotPosition(splittedString);
           symbolRepository.put(splittedString[position-1], splittedString[position+1]);
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
