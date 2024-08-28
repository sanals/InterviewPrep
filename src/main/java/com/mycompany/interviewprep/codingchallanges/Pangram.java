/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep.codingchallanges;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sanal
 */
public class Pangram {

    static String pangram01 = "The quick brown fox jumps over the lazy dog";
    static String pangram02 = "Jackdaws love my big sphinx of quartz";
    static String pangram03 = "Pack my box with five dozen liquor jugs";
    static String pangram04 = "Quick zephyrs blow, vexing daft Jim";
    static String pangram05 = "We promptly judged antique ivory knickknacks";
    static String pangram06 = "We promptly d antique ivory knickknacks";
    static String pangram07 = "We promptly judged g ivory knickknacks";

    public static void main(String[] args) {
        System.out.println(isPangram(pangram01));
        System.out.println(isPangram(pangram02));
        System.out.println(isPangram(pangram03));
        System.out.println(isPangram(pangram04));
        System.out.println(isPangram(pangram05));
        System.out.println(isPangram(pangram06));
        System.out.println(isPangram(pangram07));
    }

    private static String isPangram(String pangram) {
        return getCount(pangram).equals(26L) ? "'" + pangram + "' Is Pangram" : "'" + pangram + "' Is Not Pangram";
    }

    private static Long getCount(String pangram) {
        return pangram
                .replaceAll("\\s", "").toLowerCase()
                .chars().distinct()
                .count();
    }

}
