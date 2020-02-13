package com.finleap;

import com.finleap.parser.InputParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        InputParser parser = new InputParser();
        while ((line=reader.readLine())!=null&&!line.equals("EOF")){
              parser.parse(line);
        }
    }
}
