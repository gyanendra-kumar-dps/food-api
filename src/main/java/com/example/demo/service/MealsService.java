package com.example.demo.service;

import com.example.demo.dto.MealsDTO;
import com.example.demo.entity.Meal;
import com.example.demo.mapper.MealsMapper;
import com.example.demo.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MealsService {
    @Autowired
    private MealRepository mealRepository;
    @Autowired
    private MealsMapper mealsMapper;

    public List<MealsDTO> getAllMeals() {
        return mealRepository.findAll().stream()
                .map(mealsMapper::toDTO)
                .collect(Collectors.toList());
    }

    public MealsDTO createMeal(MealsDTO mealsDTO) {
        Meal meal = mealsMapper.toEntity(mealsDTO);
        return mealsMapper.toDTO(mealRepository.save(meal));
    }

    public MealsDTO getMealById(Integer id) {
        return mealsMapper.toDTO(mealRepository.findById(id).orElseThrow());
    }

    public MealsDTO updateMeal(Integer id, MealsDTO mealsDTO) {
        Meal meal = mealsMapper.toEntity(mealsDTO);
        meal.setId(id);
        return mealsMapper.toDTO(mealRepository.save(meal));
    }

    public void deleteMeal(Integer id) {
        mealRepository.deleteById(id);
    }
}
