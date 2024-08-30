/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.interviewprep.record;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author sanal
 */
public class SortBys {

    record Employees(String name, int age, String gender, String dept) {}

    public static void main(String[] args) {
        List<Employees> emps = new ArrayList<>();
        emps.add(new Employees("n01", 88, "m", "dev"));
        emps.add(new Employees("n02", 23, "m", "pmo"));
        emps.add(new Employees("n03", 65, "f", "dev"));
        emps.add(new Employees("n04", 34, "f", "pmo"));
        emps.add(new Employees("n05", 23, "m", "it"));
        emps.add(new Employees("n06", 88, "m", "dev"));
        emps.add(new Employees("n07", 23, "m", "pmo"));
        emps.add(new Employees("n08", 99, "m", "it"));
        emps.add(new Employees("n09", 11, "m", "pmo"));
        emps.add(new Employees("n10", 99, "m", "dev"));
        emps.add(new Employees("n11", 11, "m", "it"));
//        sortByDeptAsc(emps);
//        System.out.println("");
//        sortByDeptAscThenByGenderInAsc(emps);
//        System.out.println("");
//        sortByDeptAscThenByGenderInDesc(emps);
//        System.out.println("");
//        sortByDeptAscThenByAgeInDesc(emps);
//        System.out.println("");
        filterByGenderAndSortByNameAndGetSecondHighestAge(emps);
    }

    private static void filterByGenderAndSortByNameAndGetSecondHighestAge(List<Employees> emps) {
        Employees ems = emps.stream()
                .filter(e -> e.gender.equals("m"))
                .sorted(Comparator.comparing(Employees::name))//only needed if you want to sort by name before getting by distinct age in next line
                .collect(Collectors.toMap(Employees::age, Function.identity(), (e1, e2)->e1))
                .values()
                .stream()
                .sorted(Comparator.comparing(Employees::age).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
        System.out.println("e: "+ems);
    }

    private static void sortByDeptAscThenByAgeInDesc(List<Employees> emps) {
        emps.stream()
                .sorted(
                        Comparator.comparing(Employees::dept)
                                .thenComparing(Comparator.comparing(Employees::age).reversed())
                )
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e));
    }

    private static void sortByDeptAscThenByGenderInDesc(List<Employees> emps) {
        emps.stream()
                .sorted(
                        Comparator.comparing(Employees::dept)
                                .thenComparing(Comparator.comparing(Employees::gender).reversed())
                )
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e));
    }

    private static void sortByDeptAscThenByGenderInAsc(List<Employees> emps) {
        emps.stream()
                .sorted(
                        Comparator.comparing(Employees::dept)
                                .thenComparing(Comparator.comparing(Employees::gender))
                )
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e));
    }

    private static void sortByDeptAsc(List<Employees> emps) {
        emps.stream()
                .sorted(
                        Comparator.comparing(e -> e.dept())
                )
                .collect(Collectors.toList())
                .forEach(e -> System.out.println(e));
    }
}
