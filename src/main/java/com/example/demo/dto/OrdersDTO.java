package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class OrdersDTO {
    private Integer id;
    private List<MealsDTO> items;
    private Double total;
}
