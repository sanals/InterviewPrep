/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep.codingchallanges;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 *
 * @author sanal
 */
public class CharacterCount {

    static String somethingTocount = "somethingTocount";

    public static void main(String[] args) {
        withString();
        withCharacter();
        withComparingByKey_toMap();
        withValue();
    }
    
    private static void withString(){
        somethingTocount.toLowerCase().chars()
                .sorted()
                .mapToObj(i -> "" + (char) i)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2)->s1.getKey().charAt(0)>s2.getKey().charAt(0)? 1:(Objects.equals(s1.getKey(), s2.getKey())? 0 : -1))
                .collect(Collectors.toList())
                .forEach(a->System.out.println(a));
    }
    
    private static void withCharacter(){
        somethingTocount.toLowerCase().chars()
                .sorted()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((s1, s2)->s1.getKey()>s2.getKey()? 1:(Objects.equals(s1.getKey(), s2.getKey())? 0 : -1))
                .collect(Collectors.toList())
                .forEach(a->System.out.println(a));
    }
    
    private static void withComparingByKey_toMap(){
        somethingTocount.toLowerCase().chars()
                .sorted()
                .mapToObj(i -> "" + (char) i)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function (not needed here)
                        LinkedHashMap::new // Maintain insertion order
                ))
                .forEach((k, v)->System.out.println("k:"+k+", v:"+v));
    }
    
    private static void withValue(){
        somethingTocount.toLowerCase().chars()
                .sorted()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, // Merge function (not needed here)
                        LinkedHashMap::new // Maintain insertion order
                ))
                .forEach((k, v)->System.out.println("k:"+k+", v:"+v));
    }
}
