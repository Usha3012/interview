package com.finleap.parser;

import com.finleap.processor.InputProcessor;
import com.finleap.processor.InputProcessorFactory;

public class InputParser {
    private static final String REGEX_SYMBOL = "^(how much is )[a-zA-Z ]+(\\?)$";
    private static final String REGEX_CREDIT = "^(how many Credits is )[a-zA-Z ]+(\\?)$";
    public void parse(String inputString) {

            InputProcessorFactory.getProcessor(inputString).process(inputString);

    }

}
