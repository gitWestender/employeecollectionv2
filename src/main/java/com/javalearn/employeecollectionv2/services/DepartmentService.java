package com.javalearn.employeecollectionv2.services;

import com.javalearn.employeecollectionv2.interfaces.IDepartmentService;
import com.javalearn.employeecollectionv2.models.Employee;

import java.util.List;
import java.util.Map;

public class DepartmentService implements IDepartmentService {
    private final EmployeeService empService;
    public DepartmentService(EmployeeService empService) {
        this.empService = empService;
    }

    @Override
    public Employee findMaxSalaryOnDepart(int department) {
        return null;
    }

    @Override
    public Employee findMinSalaryOnDepart(int department) {
        return null;
    }

    @Override
    public List<Employee> findAllOnDepart(int department) {
        return null;
    }

    @Override
    public Map<Integer, List<Employee>> findAll() {
        return null;
    }

    @Override
    public Double sumOfSalary(int department) {
        return null;
    }
}
