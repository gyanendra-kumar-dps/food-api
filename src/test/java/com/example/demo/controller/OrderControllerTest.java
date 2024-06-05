// src/test/java/com/example/demo/controller/OrdersControllerTest.java
package com.example.demo.controller;

import com.example.demo.dto.MealsDTO;
import com.example.demo.dto.OrdersDTO;
import com.example.demo.service.OrdersService;
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
public class OrderControllerTest {

    @InjectMocks
    private OrdersController ordersController;

    @Mock
    private OrdersService ordersService;


    @Test
    public void testGetAllOrders() throws Exception {
        when(ordersService.getAllOrders()).thenReturn(Collections.emptyList());
        ResponseEntity<List<OrdersDTO>> response = ordersController.getAllOrders();
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(0, response.getBody().size());
    }
}
