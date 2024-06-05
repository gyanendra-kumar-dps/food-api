// src/main/java/com/example/demo/controller/MealsController.java
package com.example.demo.controller;

import com.example.demo.dto.MealsDTO;
import com.example.demo.service.MealsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/meals")
@RequiredArgsConstructor
public class MealsController {
    @Autowired
    private MealsService mealsService;

    @GetMapping
    public ResponseEntity<List<MealsDTO>> getAllMeals() {
        return ResponseEntity.ok(mealsService.getAllMeals());
    }

    @PostMapping
    public ResponseEntity<MealsDTO> createMeal(@RequestBody MealsDTO mealsDTO) {
        return ResponseEntity.ok(mealsService.createMeal(mealsDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MealsDTO> getMealById(@PathVariable Integer id) {
        return ResponseEntity.ok(mealsService.getMealById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MealsDTO> updateMeal(@PathVariable Integer id, @RequestBody MealsDTO mealsDTO) {
        return ResponseEntity.ok(mealsService.updateMeal(id, mealsDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable String id) {
        mealsService.deleteMeal(Integer.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
