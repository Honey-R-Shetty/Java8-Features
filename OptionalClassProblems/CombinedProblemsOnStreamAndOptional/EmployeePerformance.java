package OptionalClassProblems.CombinedProblemsOnStreamAndOptional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeePerformance {
	public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee(1, "Alice", "IT", 60000),
            new Employee(2, "Bob", "HR", 40000),
            new Employee(3, "Charlie", "IT", 55000),
            new Employee(4, "Daisy", "HR", 45000),
            new Employee(5, "Eve", "Finance", 70000)
        );
        
     // Employees in IT earning > 50,000
        System.out.println("IT employees with salary > 50,000:");
        
        List<Employee> employee = employees.stream()
        		.filter(e ->e.salary>50000)
        		.collect(Collectors.toList());
        employee.forEach(System.out::println);
        
        // Count employees in HR
        long hrCount = employees.stream()
        		.filter(s -> s.department.equalsIgnoreCase("hr"))
        		.count();
        System.out.println("\nTotal HRs: "+hrCount);
        
        // Employee with highest salary
        Optional<Employee> maxSalary = employees.stream()
        		.max(Comparator.comparingDouble(s -> s.salary));
        System.out.println("\nHighest paid employee:");
        maxSalary.ifPresentOrElse(System.out::println, ()->System.out.println("Employee not present !!"));
        		
	}
}
