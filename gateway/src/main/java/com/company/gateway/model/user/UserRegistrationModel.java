package com.company.gateway.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationModel{
    private String email;
    private String password;
    private String fullName;
    private String phone;
    private Long groupId;
}