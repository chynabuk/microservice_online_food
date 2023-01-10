package com.company.gateway.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserModel {
    private Long id;
    private String email;
    private String fullName;
    private String role;
    private String phone;
}