package com.company.gateway.controllers;

import com.company.gateway.entity.User;
import com.company.gateway.model.user.UserModel;
import com.company.gateway.model.user.UserRegistrationModel;
import com.company.gateway.service.UserService;
import com.company.gateway.model.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public Response<UserModel> register(@RequestBody UserRegistrationModel userRegistrationModel){
        return new Response<>(userService.register(userRegistrationModel));
    }

    @GetMapping("/get-myself2")
    public User getMyself2(){
        return userService.getMyself();
    }
}
