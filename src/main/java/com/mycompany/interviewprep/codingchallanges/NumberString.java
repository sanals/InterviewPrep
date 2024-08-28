/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep.codingchallanges;

import java.util.function.BinaryOperator;

/**
 *
 * @author sanal
 */
public class NumberString {

    private static String addHyphenInBetweentwoConsiquentOddNumberStrings = "145777";

    public static void main(String[] args) {
        addHyphenInBetweentwoConsiquentOddNumberStrings();
        addHyphenInBetweentwoConsiquentOddNumberStrings_Chars();
    }

    private static void addHyphenInBetweentwoConsiquentOddNumberStrings() {
        String x = addHyphenInBetweentwoConsiquentOddNumberStrings.chars()
                .mapToObj(i -> "" + (char) i)
                .reduce((prev, current) -> {
                    if (Integer.parseInt(prev.substring(prev.length() - 1)) % 2 != 0
                            && Integer.parseInt(current) % 2 != 0) {
                        return prev + "-" + current;
                    } else {
                        return prev + current;
                    }
                })
                .orElse("");
        System.out.println("x: " + x);
    }

    private static void addHyphenInBetweentwoConsiquentOddNumberStrings_Chars() {
        String x = addHyphenInBetweentwoConsiquentOddNumberStrings.chars()
                .mapToObj(i -> "" + (char) i)
                .reduce((prev, current) -> {
                    if (Character.getNumericValue(prev.charAt(prev.length() - 1)) % 2 != 0
                            && Character.getNumericValue(current.charAt(0)) % 2 != 0) {
                        return prev + "-" + current;
                    } else {
                        return prev + current;
                    }
                })
                .orElse("");
        System.out.println("x: " + x);
    }

    //step by step
    private static class HyphenInserter implements BinaryOperator<String> {

        @Override
        public String apply(String prev, String current) {
            if (Character.getNumericValue(prev.charAt(prev.length() - 1)) % 2 != 0
                    && Character.getNumericValue(current.charAt(current.length() - 1)) % 2 != 0) {
                return prev + "-" + current;
            } else {
                return prev + current;
            }
        }
    }
}
