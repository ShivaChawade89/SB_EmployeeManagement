package com.shiv.SB_EmployeeManagement.Service;

import com.shiv.SB_EmployeeManagement.model.Employee;
import com.shiv.SB_EmployeeManagement.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepo employeeRepo;

    public ResponseEntity<String> addEmployee(Employee employee) {
        employee.setSalary(-1L);
        employee.setJobRole("");
          employeeRepo.save(employee);

          return new ResponseEntity<>("saved",HttpStatus.OK);
    }


    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public ResponseEntity<String> update(Employee employee, int id) {
        if(!employeeRepo.findById(id).isPresent()){
            return new ResponseEntity<>("record not found",HttpStatus.NOT_FOUND);
        }

        Employee employee1 =employeeRepo.findById(id).get();

        if(employee.getJobRole()!=null)
            employee1.setJobRole(employee.getJobRole());
        if(employee.getEmail()!=null)
            employee1.setEmail(employee.getEmail());
        if(employee.getSalary()!=null)
            employee1.setSalary(employee.getSalary());
        if(employee.getFirstName()!=null)
            employee1.setFirstName(employee.getFirstName());
        if(employee.getLastName()!=null)
            employee1.setFirstName(employee.getLastName());
        if(employee.getPhoneNumber()!=null)
            employee1.setPhoneNumber(employee.getPhoneNumber());

        employeeRepo.save(employee1);
        return new ResponseEntity<>("successfully updates",HttpStatus.OK);
    }
}
