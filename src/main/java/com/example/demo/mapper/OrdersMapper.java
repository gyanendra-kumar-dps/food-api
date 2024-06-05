// src/main/java/com/example/demo/mapper/OrdersMapper.java
package com.example.demo.mapper;

import com.example.demo.dto.OrdersDTO;
import com.example.demo.entity.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    Order toEntity(OrdersDTO ordersDTO);
    OrdersDTO toDTO(Order order);
}
