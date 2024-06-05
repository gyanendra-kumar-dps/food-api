package com.example.demo.controller;

import com.example.demo.dto.OrdersDTO;
import com.example.demo.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/orders")
@RequiredArgsConstructor
public class OrdersController {
    @Autowired
    private final OrdersService ordersService;

    @GetMapping
    public ResponseEntity<List<OrdersDTO>> getAllOrders() {
        return ResponseEntity.ok(ordersService.getAllOrders());
    }

    @PostMapping
    public ResponseEntity<OrdersDTO> createOrder(@RequestBody OrdersDTO ordersDTO) {
        return ResponseEntity.ok(ordersService.createOrder(ordersDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdersDTO> getOrderById(@PathVariable Integer id) {
        return ResponseEntity.ok(ordersService.getOrderById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrdersDTO> updateOrder(@PathVariable Integer id, @RequestBody OrdersDTO ordersDTO) {
        return ResponseEntity.ok(ordersService.updateOrder(id, ordersDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        ordersService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
