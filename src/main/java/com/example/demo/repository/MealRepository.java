// src/main/java/com/example/demo/repository/MealRepository.java
package com.example.demo.repository;

import com.example.demo.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Integer> {
}
