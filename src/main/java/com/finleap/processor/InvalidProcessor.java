package com.finleap.processor;

public class InvalidProcessor implements InputProcessor {
    @Override
    public void process(String input) {
        System.out.println("I have no idea what are you talking about");
    }
}
