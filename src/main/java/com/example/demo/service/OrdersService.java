package com.example.demo.service;

import com.example.demo.dto.OrdersDTO;
import com.example.demo.entity.Order;
import com.example.demo.mapper.OrdersMapper;
import com.example.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrdersService {
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final OrdersMapper ordersMapper;

    public List<OrdersDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(ordersMapper::toDTO)
                .collect(Collectors.toList());
    }

    public OrdersDTO createOrder(OrdersDTO ordersDTO) {
        Order order = ordersMapper.toEntity(ordersDTO);
        return ordersMapper.toDTO(orderRepository.save(order));
    }

    public OrdersDTO getOrderById(Integer id) {
        return ordersMapper.toDTO(orderRepository.findById(id).orElseThrow());
    }

    public OrdersDTO updateOrder(Integer id, OrdersDTO ordersDTO) {
        Order order = ordersMapper.toEntity(ordersDTO);
        order.setId(id);
        return ordersMapper.toDTO(orderRepository.save(order));
    }

    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
