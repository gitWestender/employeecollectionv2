package com.javalearn.employeecollectionv2.controllers;

import com.javalearn.employeecollectionv2.interfaces.IEmployeeService;
import com.javalearn.employeecollectionv2.models.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final IEmployeeService iEmployeeService;

    public EmployeeController(IEmployeeService iEmployeeService) {
        this.iEmployeeService = iEmployeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName,
                                @RequestParam Double salary, @RequestParam int department) {
        return iEmployeeService.addEmployee(firstName, lastName, salary, department);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return iEmployeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return iEmployeeService.findEmployee(firstName, lastName);
    }

    @GetMapping("/findAll")
    public Collection<Employee> findAllEmployees() {
        return iEmployeeService.findAllEmloyees().values();
    }
}
