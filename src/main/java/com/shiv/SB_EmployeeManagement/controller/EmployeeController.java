package com.shiv.SB_EmployeeManagement.controller;

import com.shiv.SB_EmployeeManagement.Service.EmployeeService;
import com.shiv.SB_EmployeeManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @PostMapping()
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }
    @GetMapping("GetAllEmployee")
    public List<Employee> getEmployees(){
       return employeeService.getAll();
    }

    @PutMapping("updateEmployee/{id}")
    public ResponseEntity<String> update(@RequestBody Employee employee, @PathVariable int id){
        return employeeService.update(employee,id);
    }



}
