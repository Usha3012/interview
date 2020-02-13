package com.finleap;

import com.finleap.converter.RomanToDecimalConverter;
import org.junit.Assert;
import org.junit.Test;

public class RomanConverterTest {

    @Test
    public void testRomanToDecimal(){
        RomanToDecimalConverter converter = new RomanToDecimalConverter();
        Assert.assertEquals(1903,converter.toDecimal("MCMIII").intValue());
    }
}
