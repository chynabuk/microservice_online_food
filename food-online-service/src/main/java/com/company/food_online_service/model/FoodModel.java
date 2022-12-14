package com.company.food_online_service.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodModel {
    private Long id;
    private String name;
    private String description;
    private Float mass;
    private Float price;
}
