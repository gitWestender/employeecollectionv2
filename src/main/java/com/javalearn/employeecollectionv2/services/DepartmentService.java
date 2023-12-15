package com.javalearn.employeecollectionv2.services;

import com.javalearn.employeecollectionv2.exceptions.EmployeeNotFoundException;
import com.javalearn.employeecollectionv2.interfaces.IDepartmentService;
import com.javalearn.employeecollectionv2.models.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentService implements IDepartmentService {
    private final EmployeeService empService;

    public DepartmentService(EmployeeService empService) {
        this.empService = empService;
    }

    @Override
    public Employee findMaxSalaryOnDepart(int department) {
        return empService.createList().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingDouble(emp -> emp.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee findMinSalaryOnDepart(int department) {
        return empService.createList().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingDouble(emp -> emp.getSalary()))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public List<Employee> findAllOnDepart(int department) {
        final List<Employee> departEmployees = empService.createList().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
        if (departEmployees.isEmpty()) {
            throw new EmployeeNotFoundException();
        } else {
            return departEmployees;
        }
    }

    @Override
    public Map<Integer, List<Employee>> findAll() {
        final Map<Integer, List<Employee>> emps = empService.createList().stream()
                .collect(Collectors.groupingBy(e->e.getDepartment()));
        return emps;
    }

    @Override
    public Double sumOfSalary(int department) {
        return empService.createList().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToDouble(Employee::getSalary).sum();
    }
}
