package com.finleap.converter;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RomanToDecimalConverter {
    private static final java.lang.String DELIMITER = " ";
    private static final String REGEX_SYMBOLS = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    public static Map<String, String> romanKeyMappings = new LinkedHashMap<>();

    static {
        romanKeyMappings.put("IV", " 4 ");
        romanKeyMappings.put("IX", " 9 ");
        romanKeyMappings.put("XL", " 40 ");
        romanKeyMappings.put("XC", " 90 ");
        romanKeyMappings.put("CD", " 400 ");
        romanKeyMappings.put("CM", " 900 ");
        romanKeyMappings.put("I", " 1 ");
        romanKeyMappings.put("V", " 5 ");
        romanKeyMappings.put("X", " 10 ");
        romanKeyMappings.put("L", " 50 ");
        romanKeyMappings.put("C", " 100 ");
        romanKeyMappings.put("D", " 500 ");
        romanKeyMappings.put("M", " 1000 ");
    }

    public static BigDecimal toDecimal(String roman){
        validate(roman);
        String internalCopy=roman;
        for ( String key : romanKeyMappings.keySet() ) {

            internalCopy=internalCopy.replaceAll(key,romanKeyMappings.get(key));
        }
        BigDecimal decimal= toDecimalValue(internalCopy);
        return decimal;
    }

    private static BigDecimal toDecimalValue(String romanWithSpace) {
        BigDecimal sum = new BigDecimal(0);

        for (String element : romanWithSpace.trim().replaceAll("  ", " ").split(DELIMITER)) {
            sum = sum.add(new BigDecimal(element.trim()));
        }
        return sum;
    }

    private static void validate(String roman) {
        if (!roman.matches(REGEX_SYMBOLS)) {
            throw new IllegalArgumentException("Invalid symbol in the input: " + roman);
        }
    }
}
