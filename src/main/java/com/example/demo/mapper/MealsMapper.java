// src/main/java/com/example/demo/mapper/MealsMapper.java
package com.example.demo.mapper;

import com.example.demo.dto.MealsDTO;
import com.example.demo.entity.Meal;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MealsMapper {
    Meal toEntity(MealsDTO mealsDTO);
    MealsDTO toDTO(Meal meal);
}
