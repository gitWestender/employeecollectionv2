package com.javalearn.employeecollectionv2.services;

import com.javalearn.employeecollectionv2.exceptions.EmployeeAlreadyAddedException;
import com.javalearn.employeecollectionv2.exceptions.EmployeeIllegalNameException;
import com.javalearn.employeecollectionv2.exceptions.EmployeeNotFoundException;
import com.javalearn.employeecollectionv2.models.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTests {
    @Mock
    private EmployeeService employeeService;
    @InjectMocks
    private DepartmentService out;

    Employee emp = new Employee("Ильич", "Ленин", 5000d, 2);
    public static final Employee MAX_SALARY_EMP =
            new Employee("Зарплата", "Максимальная", 1_000_000d, 1);
    public static final Employee MIN_SALARY_EMP =
            new Employee("Зарплата", "Минимальная", 1d, 1);
    public static final List<Employee> EMPS = List.of(MAX_SALARY_EMP, MIN_SALARY_EMP);

    @Test
    public void shouldCallEmpServiceWhenAdd() {
        when(employeeService.addEmployee("Ильич", "Ленин", 5000d, 1))
                .thenReturn(emp);
        assertNotNull(employeeService.addEmployee("Ильич", "Ленин", 5000d, 1));
        assertEquals(2, emp.getDepartment());
        verify(employeeService, atLeastOnce())
                .addEmployee("Ильич", "Ленин", 5000d, 1);
    }

    @Test
    public void shouldCallEmpServiceWhenRemove() {
        when(employeeService.removeEmployee("Ильич", "Ленин"))
                .thenReturn(emp);
        assertNotNull(employeeService.removeEmployee("Ильич", "Ленин"));
        assertEquals(employeeService.removeEmployee("Ильич", "Ленин"), emp);
        assertEquals(2, emp.getDepartment());
        verify(employeeService, times(2)).removeEmployee("Ильич", "Ленин");
    }

    @Test
    public void shouldCallEmpServiceWhenFind() {
        when(employeeService.findEmployee("Ильич", "Ленин"))
                .thenReturn(emp);
        assertNotNull(employeeService.findEmployee("Ильич", "Ленин"));
        assertEquals(employeeService.findEmployee("Ильич", "Ленин"), emp);
        assertEquals(2, emp.getDepartment());
        verify(employeeService, times(2)).findEmployee("Ильич", "Ленин");
    }

    @Test
    public void shouldFindAll() {
        Map<String, Employee> expected = new HashMap<>();
        when(employeeService.findAllEmloyees())
                .thenReturn(expected);
        assertTrue(employeeService.findAllEmloyees().isEmpty());
        verify(employeeService, atLeastOnce()).findAllEmloyees();
    }

    @Test
    public void shouldListCreated() {
        List<Employee> expected = new ArrayList<>();
        when(employeeService.createList())
                .thenReturn(expected);
        assertTrue(employeeService.createList().isEmpty());
        verify(employeeService, times(2)).createList();
    }

    @Test
    public void shouldFindMaxSalaryOnDepart() {
        when(employeeService.createList())
                .thenReturn(EMPS);
        assertEquals(MAX_SALARY_EMP, out.findMaxSalaryOnDepart(1));
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.findMaxSalaryOnDepart(5);
                });
    }

    @Test
    public void shouldFindMinSalaryOnDepart() {
        when(employeeService.createList())
                .thenReturn(EMPS);
        assertEquals(MIN_SALARY_EMP, out.findMinSalaryOnDepart(1));
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.findMinSalaryOnDepart(5);
                });
    }

    @Test
    public void shouldGetSumOfSalary() {
        when(employeeService.createList())
                .thenReturn(EMPS);
        assertTrue(out.sumOfSalary(1) == 1_000_001d);
    }

    @Test
    public void shouldFindOnDepart() {
        when(employeeService.createList())
                .thenReturn(EMPS);
        assertIterableEquals(EMPS, out.findAllOnDepart(1));
        assertThrows(EmployeeNotFoundException.class,
                () -> {
                    out.findAllOnDepart(5);
                });
    }

    @Test
    public void shouldFindOnAllDepart() {
        when(employeeService.createList())
                .thenReturn(EMPS);
        assertTrue(out.findAll().containsValue(EMPS));
    }

    @Test
    public void shouldExceptionWhenAdd() {
        when(employeeService.addEmployee("!Ильич", "@Ленин", 5000d, 2))
                .thenThrow(EmployeeIllegalNameException.class);
        when(employeeService.addEmployee("Ильич", "Ленин", 5000d, 2))
                .thenThrow(EmployeeAlreadyAddedException.class);
        assertThrows(EmployeeIllegalNameException.class,
                () -> employeeService.addEmployee("!Ильич", "@Ленин", 5000d, 2));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> employeeService.addEmployee("Ильич", "Ленин", 5000d, 2));
    }

    @Test
    public void shouldExpectionWhenRemove() {
        when(employeeService.removeEmployee("Ильич", "Ленин"))
                .thenThrow(EmployeeNotFoundException.class);
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee("Ильич", "Ленин"));
    }

    @Test
    public void shouldExpectionWhenFind() {
        when(employeeService.findEmployee("Ильич", "Ленин"))
                .thenThrow(EmployeeNotFoundException.class);
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.findEmployee("Ильич", "Ленин"));
    }
}
