package com.finleap.processor;

import com.finleap.calculator.CreditCalculator;
import com.finleap.calculator.SymbolCalculator;
import com.finleap.converter.RomanToDecimalConverter;
import com.finleap.repository.CreditsRepository;
import com.finleap.repository.SymbolRepository;

public class StatementProcessor implements InputProcessor {
    private static final String REGEX_SYMBOL = "^[a-zA-Z]+( is )(I|V|X|L|C|D|M)$";
    private static final String REGEX_CREDIT = "^[a-zA-Z ]*[a-zA-Z]+( is )[0-9]+( Credits)$";
    private final String PIVOT = "is";
    private final String DELIMITER = " ";
    private SymbolRepository symbolRepository;
    private CreditsRepository creditsRepository;
    public StatementProcessor(SymbolRepository symbolRepository,CreditsRepository creditsRepository){
        this.symbolRepository = symbolRepository;
        this.creditsRepository = creditsRepository;
    }
    public void process(String input) {
        if(input.matches(REGEX_SYMBOL)){
            new SymbolCalculator(symbolRepository).calculateAndPut(input);
        }else if(input.matches(REGEX_CREDIT)) {
            new CreditCalculator(symbolRepository,creditsRepository).calculateAndPut(input);
        }
    }
}
