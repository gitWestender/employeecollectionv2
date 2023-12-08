package com.javalearn.employeecollectionv2.interfaces;

import com.javalearn.employeecollectionv2.models.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    Employee addEmployee(String firstName, String lastName, Double salary, int department);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    List<Employee> createList();
    Map<String, Employee> findAllEmloyees();
}
