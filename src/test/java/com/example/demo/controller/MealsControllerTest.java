// src/test/java/com/example/demo/controller/MealsControllerTest.java
package com.example.demo.controller;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.MealsDTO;
import com.example.demo.service.MealsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class MealsControllerTest {

    @InjectMocks
    private MealsController mealsController;

    @Mock
    private MealsService mealsService;

    @Test
    public void testGetAllMeals() throws Exception {

        when(mealsService.getAllMeals()).thenReturn(Collections.emptyList());
        ResponseEntity<List<MealsDTO>> response = mealsController.getAllMeals();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }
}
