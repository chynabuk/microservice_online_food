package com.company.order_service.model;

import com.company.order_service.enums.Status;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel {
    private Long id;
    private Long userId;
    private String auth;
    private Long foodId;
    private Status status;
    private LocalDateTime orderedDate;
}
