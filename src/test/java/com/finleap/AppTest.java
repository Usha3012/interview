package com.finleap;

import com.finleap.parser.InputParser;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void parserShouldParseValidCreditQuestion(){
        String question = "glob is I\n" +
                "prok is V\n"+
                "pish is X\n"+
                "tegj is L\n"+
                "glob glob Silver is 34 Credits\n"+
                "glob prok Gold is 57800 Credits\n"+
                "Credits pish pish Iron is 3910 Credits\n"+
                "how much is pish tegj glob glob?\n"+
                "Credit how much is pish tegj glob glob ?";
        new InputParser().parse(question);

    }
}
