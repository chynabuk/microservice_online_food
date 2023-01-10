package com.company.gateway.service;

import com.company.gateway.entity.User;
import com.company.gateway.model.user.UserModel;
import com.company.gateway.model.user.UserRegistrationModel;

public interface UserService {
    UserModel register(UserRegistrationModel userRegistrationModel);
    User getMyself();
}
