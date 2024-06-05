package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meal_seq")
    private Integer id;
    private String name;
    private String price;
    private String description;
    private String image;

    @ManyToMany(mappedBy = "items", fetch = FetchType.LAZY)
    private List<Order> order;
}
