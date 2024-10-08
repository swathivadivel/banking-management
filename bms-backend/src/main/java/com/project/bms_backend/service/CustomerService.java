package com.project.bms_backend.service;

import com.project.bms_backend.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    List<CustomerDto> getCustomers();

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getEmployeeById(long id);

    CustomerDto updateCustomer(long id, CustomerDto customerDto);

    void deleteCustomer(long id);
}
