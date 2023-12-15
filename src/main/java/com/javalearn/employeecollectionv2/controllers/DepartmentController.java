package com.javalearn.employeecollectionv2.controllers;

import com.javalearn.employeecollectionv2.interfaces.IDepartmentService;
import com.javalearn.employeecollectionv2.models.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final IDepartmentService iDepartmentService;

    public DepartmentController(IDepartmentService iDepartmentService) {
        this.iDepartmentService = iDepartmentService;
    }

    @GetMapping("/{id}/max-salary")
    public Employee findMaxSalaryOnDepart(@PathVariable("id") int depart) {
        return iDepartmentService.findMaxSalaryOnDepart(depart);
    }

    @GetMapping("/{id}/min-salary")
    public Employee findMinSalaryOnDepart(@PathVariable("id") int depart) {
        return iDepartmentService.findMinSalaryOnDepart(depart);
    }

    @GetMapping("/{id}/all")
    public List<Employee> findAllOnDepart(@PathVariable("id") int depart) {
        return iDepartmentService.findAllOnDepart(depart);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> findAll() {
        return iDepartmentService.findAll();
    }

    @GetMapping("/{id}/salary/sum")
    public Double sumOfSalary(@PathVariable("id") int depart) {
        return iDepartmentService.sumOfSalary(depart);
    }

}
