// src/test/java/com/example/demo/service/MealsServiceTest.java
package com.example.demo.service;

import com.example.demo.dto.MealsDTO;
import com.example.demo.entity.Meal;
import com.example.demo.mapper.MealsMapper;
import com.example.demo.repository.MealRepository;
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
public class MealServiceTest {

    @Mock
    private MealRepository mealRepository;

    @Mock
    private MealsMapper mealsMapper;

    @InjectMocks
    private MealsService mealsService;

    @Test
    public void testGetAllMeals() {
        Meal meal = new Meal();
        MealsDTO mealsDTO = new MealsDTO();

        when(mealRepository.findAll()).thenReturn(Collections.singletonList(meal));
        when(mealsMapper.toDTO(meal)).thenReturn(mealsDTO);

        assertEquals(1, mealsService.getAllMeals().size());
    }
}
