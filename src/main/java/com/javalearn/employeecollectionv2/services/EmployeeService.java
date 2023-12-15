package com.javalearn.employeecollectionv2.services;

import com.javalearn.employeecollectionv2.exceptions.EmployeeAlreadyAddedException;
import com.javalearn.employeecollectionv2.exceptions.EmployeeIllegalNameException;
import com.javalearn.employeecollectionv2.exceptions.EmployeeNotFoundException;
import com.javalearn.employeecollectionv2.interfaces.IEmployeeService;
import com.javalearn.employeecollectionv2.models.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.*;

public class EmployeeService implements IEmployeeService {
    private final Map<String, Employee> employeeMap = new HashMap<>(Map.of(
            "ОлегОлегович", new Employee("Олег", "Олегович", 85000d, 1),
            "НиколайНиколаевич", new Employee("Николай", "Николаевич", 68000d, 3),
            "ДаниилБатькович", new Employee("Даниил", "Батькович", 69000d, 2),
            "КузьмаЛарионович", new Employee("Кузьма", "Ларионович", 50000d, 3),
            "СофьяКузьминична", new Employee("Софья", "Кузьминична", 46500d, 3)
    ));

    @Override
    public Employee addEmployee(String firstName, String lastName, Double salary, int department) {
        if (isAlpha(firstName) && isAlpha(lastName)) {
            Employee emp = new Employee(firstName, lastName, salary, department);
            String fullName = firstName + lastName;

            if (!employeeMap.containsKey(fullName)) {
                employeeMap.put(fullName, emp);
                return emp;
            } else {
                throw new EmployeeAlreadyAddedException("Сотрудник уже присутствует");
            }
        } else {
            throw new EmployeeIllegalNameException("Некорректно указано имя или фамилия");
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        String fullName = firstName + lastName;

        if (employeeMap.containsKey(fullName)) {
            employeeMap.remove(fullName);
            return employeeMap.get(fullName);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }

    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String fullName = firstName + lastName;

        if (employeeMap.containsKey(fullName)) {
            return employeeMap.get(fullName);
        } else {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }

    @Override
    public List<Employee> createList() {
        final List<Employee> employeesList = new ArrayList<>(employeeMap.values());
        return employeesList;
    }

    @Override
    public Map<String, Employee> findAllEmloyees() {
        return employeeMap;
    }
}
