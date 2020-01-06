package com.thymeleafdemo.demo.controller;

import com.thymeleafdemo.demo.entity.EmployeeForm;
import com.thymeleafdemo.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class EmployeeController {
    private final EmployeeService employeeService;
//    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
//        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = {"/", "/index"})
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployees());
        return "index";
    }

    @GetMapping("/add-employee")
    public String showAddEmployeePage(Model model) {
        EmployeeForm employeeForm = new EmployeeForm();
        model.addAttribute("employeeForm", employeeForm);
        return "add-employee";
    }

    @PostMapping("/add-employee")
    public String addEmployee(@ModelAttribute("employeeForm") EmployeeForm employeeForm) {
        employeeService.addEmployee(employeeForm);
        return "redirect:/";
    }
}
