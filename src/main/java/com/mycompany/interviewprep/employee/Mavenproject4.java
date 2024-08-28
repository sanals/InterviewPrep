/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.interviewprep.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author sanal
 */
public class Mavenproject4 {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee("one two", 12, "three");
        Employee employee2 = new Employee("four five", 23, "six");
        Employee employee3 = new Employee("seven eight", 55, "nine");
        Employee employee4 = new Employee("ten eleven", 94, "three");
        Employee employee5 = new Employee("twelve thirteen", 34, "six");
        Employee employee6 = new Employee("fourteen fifteen", 45, "nine");
        Employee employee7 = new Employee("sixteen seventeen", 76, "three");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        employees.add(employee6);
        employees.add(employee7);
        
        List<Employee> employeesSorted = employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .collect(Collectors.toList());
        System.out.println("employeesSorted: "+ employeesSorted);
        System.out.println("\n");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .forEach(System.out::print);
        System.out.println("\n");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .forEach(System.out::print);
        System.out.println("\n");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Comparator.comparing(Employee::getAge))
                )
                .forEach(System.out::print);
        System.out.println("\n");
        employees.stream()
                .sorted(Comparator.comparing(Employee::getAge)
                        .thenComparing(Comparator.comparing(Employee::getDepartment))
                )
                .forEach(System.out::print);
        System.out.println("\n");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((t, u) -> {
                    System.out.print("\ndep:"+t + " emp:"+u);
                });
        System.out.println("\n");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((t, u) -> {
                    System.out.print("\ndep:"+t + " count:"+u);
                });
        System.out.println("\n");
        employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getAge)))
                .forEach((t, u) -> {
                    System.out.print("\ndep:"+t + " avg:"+u);
                });
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        Map<String, Long> map =  employees.stream().collect(Collectors.groupingBy(emp->emp.getDepartment(), Collectors.counting()));
//        map.forEach((k, v) -> System.out.println("k:"+k+", v:"+v));
//        List<Employee> sortedEmployees = employees.stream()
//        .sorted(Comparator
//                .comparing(
//                        Employee::getAge
//                ) 
//                .thenComparing(
//                        Employee::getName
//                ))
//        .collect(Collectors.toList());
//        sortedEmployees.forEach(System.out::println);
    }
}
