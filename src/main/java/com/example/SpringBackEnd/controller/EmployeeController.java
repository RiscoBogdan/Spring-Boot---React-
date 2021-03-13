package com.example.SpringBackEnd.controller;
import com.example.SpringBackEnd.model.Employee;
import com.example.SpringBackEnd.repository.EmployeeRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

//@RequestMapping — For handling any request type.
//@GetMapping — For a GET request.
//@PostMapping — For a POST request.
//@PutMapping — For a PUT request.
//@PatchMapping — For a PATCH request.
//@DeleteMapping — For a DELETE request.

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//create a restAPI
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")//standard we use typically whenever we develop our http like version 1
public class EmployeeController {
    //inject employee repository
    //inject by spring container
    @Autowired //we need
    EmployeeRepository employeeRepository;
     // EmployeeData employeeRepository = new EmployeeData.getInstance(); - Single-tone - we have to create code for every request
    // get all employee for api // return List of employees for client
    @GetMapping("/employee")
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll(); //employee object
    }
    // Create employee rest api
    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //get employee by Id REST API

    //get employee by id rest api
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){

        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exception not exist at id: " + id));
        return ResponseEntity.ok(employee);
                //we also need to return http status for that we need to use ResponseEntity<Employee>
    }

    //Update employee REST API
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> UpdateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exception not exist at id: " + id));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        employee.setRating(employeeDetails.getRating());
        employee.setSalary(employeeDetails.getSalary());

        Employee updateEmpRep = employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmpRep);
    }

    //Delete employee REST API
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exception not exist at id: " + id));
        employeeRepository.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
