package com.project.bms_backend.dto;

import com.project.bms_backend.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getCustomerId(),
                customer.getCustomerName(),
                customer.getEmail()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getCustomerId(),
                customerDto.getCustomerName(),
                customerDto.getEmail()
        );
    }
}
