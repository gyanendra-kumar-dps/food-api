package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class MealsDTO {
    private Integer id;
    private String name;
    private String price;
    private String description;
    private String image;

    private List<OrdersDTO> order;
}
