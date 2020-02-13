package com.finleap.processor;

import com.finleap.converter.RomanToDecimalConverter;
import com.finleap.repository.CreditsRepository;
import com.finleap.repository.SymbolRepository;

import java.math.BigDecimal;

public class QuestionProcessor implements InputProcessor {
    private static final String REGEX_SYMBOL = "^(how much is )[a-zA-Z ]+(\\?)$";
    private static final String REGEX_CREDIT = "^(how many Credits is )[a-zA-Z ]+(\\?)$";
    private static final String PREFIX = "how much is ";
    private static final String PREFIX_Credits = "how many Credits is ";
    private static final String SUFFIX = " ?";
    private final String PIVOT = "is";
    private SymbolRepository symbolRepository;
    private CreditsRepository creditsRepository;
    public QuestionProcessor(SymbolRepository symbolRepository,CreditsRepository creditsRepository) {
        this.symbolRepository = symbolRepository;
        this.creditsRepository = creditsRepository;
    }

    public void process(String input) {
        if(!validate(input)) return;
        if(input.matches(REGEX_SYMBOL)){
            calculateWithSymbol(input);
        }else{
            calculateWithCredits(input);
        }
    }

    private void calculateWithCredits(String input) {
        BigDecimal sum = new BigDecimal(0);
        String parameters = getParameters(input);
        String[] splittedParams = parameters.split(" ");
        String key="";
        for ( int i=0;i<splittedParams.length-1;i++) {
            key+=symbolRepository.get(splittedParams[i]);
        }
        BigDecimal multiplier = RomanToDecimalConverter.toDecimal(key);
        BigDecimal creditValue = creditsRepository.get(splittedParams[splittedParams.length-1]);
        BigDecimal result = creditValue.multiply(multiplier);
        result.setScale(0);
        System.out.println(parameters+" is "+result);
    }

    private void calculateWithSymbol(String input) {
        BigDecimal sum = new BigDecimal(0);
        String parameters = getParameters(input);
        String[] splittedParams = parameters.split(" ");
        String key="";
        for ( String param : splittedParams ) {
            key+=symbolRepository.get(param);
        }
        System.out.println(parameters + " is " + RomanToDecimalConverter.toDecimal(key));
    }


    private boolean validate(String input) {
        if(!input.matches(REGEX_CREDIT) && !input.matches(REGEX_SYMBOL)){
            System.out.println("I have no idea what you are talking about");
            return false;
        }
        return true;
    }

    private String getParameters(String input) {
        if(input.startsWith(PREFIX)) {
            return input.substring(PREFIX.length(), input.length() - SUFFIX.length() + 1);
        }else{
            return input.substring(PREFIX_Credits.length(), input.length() - SUFFIX.length() + 1);
        }
    }
}
