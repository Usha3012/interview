package com.finleap.processor;

import com.finleap.repository.CreditsRepository;
import com.finleap.repository.SymbolRepository;

public class InputProcessorFactory {
    private static final SymbolRepository symbolRepository = new SymbolRepository();
    private static final CreditsRepository creditsRepository = new CreditsRepository();
    public static InputProcessor getProcessor(String input){
        if(input.endsWith("?")){
            return new QuestionProcessor(symbolRepository,creditsRepository);
        }{
            return new StatementProcessor(symbolRepository,creditsRepository);
        }

    }
}
