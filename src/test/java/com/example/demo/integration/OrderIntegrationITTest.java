// src/test/java/com/example/demo/integration/OrdersIntegrationTest.java
package com.example.demo.integration;

import com.example.demo.dto.MealsDTO;
import com.example.demo.dto.OrdersDTO;
import com.example.demo.integration.config.PostgreSQLIntegrationTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class OrderIntegrationITTest extends PostgreSQLIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateAndGetOrder() throws Exception {
        OrdersDTO ordersDTO = new OrdersDTO();
        //ordersDTO.setId(1);
        //ordersDTO.setItems(Collections.singletonList(new MealsDTO()));
        ordersDTO.setTotal(100.0);

        String jsonPayload = objectMapper.writeValueAsString(ordersDTO);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/v1/orders").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonPayload)).andExpect(status().isOk());
        String mvcResult = response.andReturn().getResponse().getContentAsString();
        ordersDTO = objectMapper.readValue(mvcResult, OrdersDTO.class);

        assertEquals(1, ordersDTO.getId());
        assertEquals(100.0, ordersDTO.getTotal());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
