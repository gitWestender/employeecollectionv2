package com.javalearn.employeecollectionv2.services;

import com.javalearn.employeecollectionv2.exceptions.EmployeeAlreadyAddedException;
import com.javalearn.employeecollectionv2.exceptions.EmployeeIllegalNameException;
import com.javalearn.employeecollectionv2.exceptions.EmployeeNotFoundException;
import com.javalearn.employeecollectionv2.interfaces.IEmployeeService;
import com.javalearn.employeecollectionv2.models.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTests {
    EmployeeService out = new EmployeeService();

    public static Stream<Arguments> provideParams() {
        return Stream.of(
                Arguments.of("Тест", "Тестовский", 4000d, 1),
                Arguments.of("Баг", "Баговский", 1400.0, 2));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    public void shouldThrowExceptionWhenAdd(String firstName, String lastName, Double salary, int department) {
        out.addEmployee(firstName, lastName, salary, department);
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> {
                    out.addEmployee(firstName, lastName, salary, department);
                });
    }

    @Test
    public void shouldThrowExceptionWhenIllegalName() {
        assertThrows(EmployeeIllegalNameException.class,
                () -> {
                    out.addEmployee("!Тест", "Тестовский@", 4000d, 1);
                });
    }

    @Test
    public void shouldThrowExceptionWhenNotFound() {
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.findEmployee("Гном", "Гномыч");
                });
    }

    @Test
    public void shouldRemoveWhenNotContains() {
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.removeEmployee("Гном", "Гномыч");
                });
    }

    @Test
    public void shouldListCreated() {
        assertNotNull(out.createList());
    }

    @Test
    public void shouldFindAllWhenNotNull() {
        assertNotNull(out.findAllEmloyees());
    }

    @Test
    public void shouldFindWhenContains() {
        assertNotNull(out.findEmployee("Гном", "Гномыч"));
    }

    @ParameterizedTest
    @MethodSource("provideParams")
    public void shouldAddWhenOnContains(String firstName, String lastName, Double salary, int department) {
        Employee temp = new Employee(firstName, lastName, salary, department);
        out.addEmployee(firstName, lastName, salary, department);
        assertEquals(out.findEmployee(firstName, lastName), temp);
    }

}
