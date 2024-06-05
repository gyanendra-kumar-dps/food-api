// src/test/java/com/example/demo/integration/MealsIntegrationITTest.java
package com.example.demo.integration;

import com.example.demo.dto.MealsDTO;
import com.example.demo.integration.config.PostgreSQLIntegrationTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MealsIntegrationITTest extends PostgreSQLIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateAndGetMeal() throws Exception {
        MealsDTO mealsDTO = new MealsDTO();
        mealsDTO.setId(1);
        mealsDTO.setName("Test Meal");
        String jsonPayload = objectMapper.writeValueAsString(mealsDTO);
        ResultActions response = mockMvc.perform(MockMvcRequestBuilders.post("/v1/meals").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content(jsonPayload)).andExpect(status().isOk());
        String mvcResult = response.andReturn().getResponse().getContentAsString();
        mealsDTO = objectMapper.readValue(mvcResult, MealsDTO.class);

        assertEquals(1, mealsDTO.getId());
        assertEquals("Test Meal", mealsDTO.getName());
    }

}
