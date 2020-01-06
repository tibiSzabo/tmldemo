package com.thymeleafdemo.demo.service;

import com.thymeleafdemo.demo.entity.Assignment;
import com.thymeleafdemo.demo.entity.Employee;
import com.thymeleafdemo.demo.entity.EmployeeForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class EmployeeService {
    private ArrayList<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        this.employees.add(new Employee(1, "Szabó", "Tibor", 25, Assignment.DEVELOPER));
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Employee addEmployee(EmployeeForm employeeForm) {
        if (employeeForm.getFirstName().isEmpty() || employeeForm.getLastName().isEmpty()) {
            return null;
        }
        Employee employee = new Employee(employeeForm.getId(),
                employeeForm.getFirstName(),
                employeeForm.getLastName(),
                employeeForm.getAge(),
                employeeForm.getAssignment());
        employees.add(employee);
        return employee;
    }
}
