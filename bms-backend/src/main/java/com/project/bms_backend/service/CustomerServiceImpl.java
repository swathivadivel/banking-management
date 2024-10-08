package com.project.bms_backend.service;

import com.project.bms_backend.dto.CustomerDto;
import com.project.bms_backend.dto.CustomerMapper;
import com.project.bms_backend.entity.Customer;
import com.project.bms_backend.exception.ResourceNotFoundException;
import com.project.bms_backend.repository.CustomerRepository;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDto> getCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return customers.stream().map((customer) -> CustomerMapper.mapToCustomerDto(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer savedCustomer = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }



    @Override
    public CustomerDto getEmployeeById(long id) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer does not exsist :" + id) );
        return CustomerMapper.mapToCustomerDto(customer);

    }

    @Override
    public CustomerDto updateCustomer(long id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer does not exsist :" + id));
        customer.setCustomerName(customerDto.getCustomerName());

        customer.setEmail(customerDto.getEmail());
        logger.info("Customer from db is {}",customer);
        Customer customer1 = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(customer1);
    }

    @Override
    public void deleteCustomer(long id) {
        customerRepository.deleteById(id);
    }
}
