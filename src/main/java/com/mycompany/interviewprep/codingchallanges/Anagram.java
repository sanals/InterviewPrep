/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep.codingchallanges;

import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * To check if two String/Numbers are Anagrams
 *
 * @author sanal
 */
public class Anagram {

    public static void main(String[] args) {
        String[] strings = readString();
        System.out.println(strings[0] + " and " + strings[1] + " are"
                + (isAnagramWithStringBuilder(strings[0], strings[1]) ? "" : " not")
                + " anagrams");

        System.out.println(strings[0] + " and " + strings[1] + " are"
                + (isAnagramWithString(strings[0], strings[1]) ? "" : " not")
                + " anagrams");

        System.out.println(strings[0] + " and " + strings[1] + " are"
                + (isAnagramArrays(strings[0], strings[1]) ? "" : " not")
                + " anagrams");

        System.out.println(strings[0] + " and " + strings[1] + " are"
                + (isAnagramUniqueArrays(strings[0], strings[1]) ? "" : " not")
                + " anagrams");

        System.out.println(strings[0] + " and " + strings[1] + " are"
                + (isAnagramUniqueCharsJava11(strings[0], strings[1]) ? "" : " not")
                + " anagrams");
        

        System.out.println(strings[0] + " and " + strings[1] + " are"
                + (isAnagramvalueOfAndCast(strings[0], strings[1]) ? "" : " not")
                + " anagrams");
    }

    private static String[] readString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter First String: ");
        String string1 = scanner.nextLine();
        System.out.println("Enter Second String: ");
        String string2 = scanner.nextLine();
        scanner.close();
//        String[] words = {string1, string2};
        return new String[]{string1, string2};
    }

    private static boolean isAnagramWithStringBuilder(String anagram1, String anagram2) {
        System.out.println("in isAnagramWithStringBuilder: " + anagram1.toLowerCase()//convert to lowercase first before sorting chars
                .chars().sorted()
                .collect(
                        StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append
                ).toString());
        
        anagram2.toLowerCase()
                                .chars().sorted()
                                .collect(
                                        ()-> new StringBuilder(), 
                                        (sb, codePoint)-> sb.appendCodePoint(codePoint), 
                                        (sb1, sb2) -> sb1.append(sb2)
                                )
                                        .toString().trim();
        return anagram1.toLowerCase()//convert to lowercase first before sorting chars
                .chars().sorted()
                .collect(
                        StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append
                ).toString().trim()
                .equals(
                        anagram2.toLowerCase()
                                .chars().sorted()
                                .collect(
                                        StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append
                                ).toString().trim()
                );
    }

    private static boolean isAnagramWithString(String anagram1, String anagram2) {
        System.out.println("in isAnagramWithString");
        anagram1.chars().sorted()
                .mapToObj(i -> Character.toString(i));
        System.out.println("1 : " + anagram1.chars().sorted().mapToObj(i -> Character.toString(i)));
        System.out.println("2 : " + anagram1.chars().sorted().mapToObj(i -> Character.toString(i)).toArray(String[]::new));
        System.out.println("3 : " + String.valueOf(anagram1.chars().sorted().mapToObj(i -> Character.toString(i)).toArray(String[]::new)));
        return String.valueOf(anagram1.chars().sorted().toArray()).equals(String.valueOf(anagram2.chars().sorted().toArray()));
    }

    private static boolean isAnagramArrays(String anagram1, String anagram2) {
        System.out.println("in isAnagramArrays");
//        Arrays.asList(anagram1.toLowerCase().toCharArray());
        char[] anagramChar1 = anagram1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] anagramChar2 = anagram2.replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(anagramChar1);// eventhough java is pass by value, since anagramChar1 is an array, a copy of the reference of this array is passed.
        Arrays.sort(anagramChar2);
        return Arrays.equals(anagramChar1, anagramChar2);
    }
    
    

    private static boolean isAnagramUniqueArrays(String anagram1, String anagram2) {
        System.out.println("in isAnagramUniqueArrays");
        char[] anagramChar1 = removeDuplicatesSet(anagram1).replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] anagramChar2 = removeDuplicatesSet(anagram1).replaceAll("\\s", "").toLowerCase().toCharArray();
        Arrays.sort(anagramChar1);// eventhough java is pass by value, since anagramChar1 is an array, a copy of the reference of this array is passed.
        Arrays.sort(anagramChar2);
        return Arrays.equals(anagramChar1, anagramChar2);
    }
    
    private static String removeDuplicatesCustom(String anagram){
        String anagramUnique = "";
        boolean[] checkChars = new boolean[256];//256 is given since that is the number of characters in ascii
        for (int i = 0; i < anagram.length(); i++) {
            if(!checkChars[anagram.charAt(i)]){
                checkChars[anagram.charAt(i)] = true;
                anagramUnique += anagram.charAt(i);
            }
        }
        return anagramUnique;
    }
    
    private static String removeDuplicatesSet(String anagram){
        Set<Character> uniques = new HashSet<>();
        for (char c: anagram.toCharArray()) {
            uniques.add(c);
        }
        return Arrays.toString(uniques.toArray());
    }

    private static boolean isAnagramUniqueCharsJava11(String anagram1, String anagram2) {
        System.out.println("in isAnagramUniqueChars");
        return anagram1.replaceAll("//s", "").chars().distinct().sorted()
                .mapToObj(i -> Character.toString(i)).collect(Collectors.joining())
                .equals(anagram2.replaceAll("//s", "").chars().distinct().sorted()
                        .mapToObj(i -> Character.toString(i)).collect(Collectors.joining()));
    }

    private static boolean isAnagramvalueOfAndCast(String anagram1, String anagram2) {
        System.out.println("in isAnagramvalueOf");
        return anagram1.replaceAll("//s", "").chars().distinct().sorted()
                .mapToObj(i->String.valueOf((char)i)).collect(Collectors.joining())
                .equals(anagram2.replaceAll("//s", "").chars().distinct().sorted()
                        .mapToObj(i->String.valueOf((char)i)).collect(Collectors.joining()));
    }
}
