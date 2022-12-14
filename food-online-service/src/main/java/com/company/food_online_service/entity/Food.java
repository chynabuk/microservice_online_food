package com.company.food_online_service.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Float mass;
    private Float price;
}