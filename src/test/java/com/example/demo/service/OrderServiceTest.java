// src/test/java/com/example/demo/service/OrdersServiceTest.java
package com.example.demo.service;

import com.example.demo.dto.OrdersDTO;
import com.example.demo.entity.Order;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrdersMapper ordersMapper;

    @InjectMocks
    private OrdersService ordersService;

    @Test
    public void testGetAllOrders() {
        Order order = new Order();
        OrdersDTO ordersDTO = new OrdersDTO();

        when(orderRepository.findAll()).thenReturn(Collections.singletonList(order));
        when(ordersMapper.toDTO(order)).thenReturn(ordersDTO);

        assertEquals(1, ordersService.getAllOrders().size());
    }
}
