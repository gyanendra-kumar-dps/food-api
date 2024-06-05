// src/test/java/com/example/demo/service/CustomerServiceTest.java
package com.example.demo.service;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void testGetAllCustomers() {
        when(customerRepository.findAll()).thenReturn(Collections.emptyList());

        List<CustomerDTO> customers = customerService.getAllCustomers();
        assertEquals(0, customers.size());
    }

    @Test
    void testGetCustomerById() {
        Customer customer = new Customer();
        when(customerRepository.findById(anyInt())).thenReturn(Optional.of(customer));

        CustomerDTO dto = customerService.getCustomerById(1);
        assertEquals(new CustomerDTO(), dto);
    }

    // Add more tests for other methods
}
