// src/test/java/com/example/demo/integration/CustomerIntegrationTest.java
package com.example.demo.integration;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.integration.config.PostgreSQLIntegrationTest;
import com.example.demo.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CustomerITTest extends PostgreSQLIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testCreateCustomer() throws Exception{
        CustomerDTO customerDTO = new CustomerDTO();
        //customerDTO.setId("1");
        customerDTO.setName("John Doe");
        customerDTO.setEmail("john@example.com");
        customerDTO.setPhone("123456789");

        String jsonPayload = objectMapper.writeValueAsString(customerDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/customers").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonPayload)).andExpect(status().isOk());

    }

    // Add more tests for other endpoints
}
