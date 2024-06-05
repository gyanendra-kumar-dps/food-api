// src/test/java/com/example/demo/repository/OrderRepositoryTest.java
package com.example.demo.repository;

import com.example.demo.entity.Order;
import com.example.demo.integration.config.PostgreSQLIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class OrderRepositoryTest extends PostgreSQLIntegrationTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void testSaveAndFindById() {
        Order order = new Order();
        order.setId(1);
        orderRepository.save(order);

        Optional<Order> found = orderRepository.findById(1);
        assertTrue(found.isPresent());
    }
}
