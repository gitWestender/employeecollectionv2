package com.javalearn.employeecollectionv2.services;

import com.javalearn.employeecollectionv2.interfaces.IEmployeeService;
import com.javalearn.employeecollectionv2.models.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements IEmployeeService {
    private final Map<String, Employee> employeeMap = new HashMap<>(Map.of(
            "ОлегОлегович",new Employee("Олег", "Олегович", 85000d, 1),
            "НиколайНиколаевич",new Employee("Николай", "Николаевич", 68000d, 3),
            "ДаниилБатькович",new Employee("Даниил","Батькович",69000d,2),
            "КузьмаЛарионович",new Employee("Кузьма","Ларионович",50000d,3),
            "СофьяКузьминична",new Employee("Софья","Кузьминична",46500d,3)
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName, Double salary, int department) {
        return null;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        return null;
    }

    @Override
    public List<Employee> createList() {
        return null;
    }

    @Override
    public Map<String, Employee> findAllEmloyees() {
        return null;
    }
}
