// src/test/java/com/example/demo/repository/MealRepositoryTest.java
package com.example.demo.repository;

import com.example.demo.entity.Meal;
import com.example.demo.integration.config.PostgreSQLIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;



public class MealRepositoryTest extends PostgreSQLIntegrationTest{

    @Autowired
    private MealRepository mealRepository;

    @Test
    public void testSaveAndFindById() {
        Meal meal = new Meal();
        meal.setId(1);
        meal.setName("Test Meal");
        mealRepository.save(meal);

        Optional<Meal> found = mealRepository.findById(1);
        assertTrue(found.isPresent());
    }
}
