package main.java.lekcje.zaawansowane_strumienie.service;

import main.java.lekcje.zaawansowane_strumienie.model.Department;
import main.java.lekcje.zaawansowane_strumienie.model.Employee;

import java.util.List;

public class CorporateSerch {
    public static void main(String[] args) {

        Department deptIT = new Department("IT", List.of(
                new Employee("Tomasz", 29, 12000.0),
                new Employee("Anna", 32, 14500.0),
                new Employee("Kamil", 25, 8000.0)
        ));

        Department deptHR = new Department("HR", List.of(
                new Employee("Jan", 45, 9000.0),
                new Employee("Ewa", 38, 10500.0)
        ));

        List<Department> company = List.of(deptIT, deptHR);


        System.out.println("Lista wszystkich pracowników:");
        company.stream()
                .flatMap(dept -> dept.employees().stream())
                .map(Employee::name)
                .sorted()
                .forEach(System.out::println);


        double topSalary = company.stream()
                .flatMap(dept -> dept.employees().stream())
                .mapToDouble(Employee::salary)
                .max()
                .orElse(0.0);

        System.out.println("\nNajwyższa pensja w firmie: " + topSalary + " PLN");

        String identity = "[KADRY] -> ";
        String employeeRoster = company.stream()
                .flatMap(dept -> dept.employees().stream())
                .map(Employee::name)
                .reduce(
                        identity,
                        (acc, name) -> acc.equals(identity) ? acc + name : acc + " | " + name
                );

        System.out.println("\nAgregator redukujący:");
        System.out.println(employeeRoster);
    }
}
