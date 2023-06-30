package com.shiv.SB_EmployeeManagement.controller;


import com.shiv.SB_EmployeeManagement.Service.HrService;
import com.shiv.SB_EmployeeManagement.dao.HrEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("hr")
public class HrController {
    @Autowired
    HrService hrService;

    @PutMapping("update_Employee_details/{id}")
    public ResponseEntity<String> updateEmployeeDetails(@RequestBody HrEmployee employee, @PathVariable int id){
        return hrService.updateDetails(employee,id);
    }

}
