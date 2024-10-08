package com.project.bms_backend.controller;


import com.project.bms_backend.dto.CustomerDto;
import com.project.bms_backend.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3002")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<List<CustomerDto>> createCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity(customerService.createCustomer(customerDto),
                HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        return  new ResponseEntity<>(customerService.getCustomers(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getEmployeeById(@PathVariable long id){
        return new ResponseEntity<>(customerService.getEmployeeById(id),HttpStatus.FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable long id, @RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.updateCustomer(id,customerDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>("Deleted Successfully :" + id,HttpStatus.OK);
    }
}
