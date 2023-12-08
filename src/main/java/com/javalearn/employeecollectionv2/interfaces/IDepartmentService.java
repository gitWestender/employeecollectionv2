package com.javalearn.employeecollectionv2.interfaces;

import com.javalearn.employeecollectionv2.models.Employee;

import java.util.List;
import java.util.Map;

public interface IDepartmentService {
    Employee findMaxSalaryOnDepart(int department);
    Employee findMinSalaryOnDepart(int department);
    List<Employee> findAllDepart(int department);
    Map<Integer, List<Employee>> findAll();
    Double sumOfSalary(int department);
}
