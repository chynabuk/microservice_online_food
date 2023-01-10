package com.company.gateway.service.impl;

import com.company.gateway.entity.User;
import com.company.gateway.enums.Role;
import com.company.gateway.exceptions.UserException;
import com.company.gateway.model.user.*;
import com.company.gateway.resository.UserRepository;
import com.company.gateway.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public UserModel register(UserRegistrationModel userRegistrationModel) {
        User user = User.builder()
                .email(userRegistrationModel.getEmail())
                .fullName(userRegistrationModel.getFullName())
                .password(encoder.encode(userRegistrationModel.getPassword()))
                .phone(userRegistrationModel.getPhone())
                .role(Role.CLIENT)
                .build();

        userRepository.save(user);
        return toModel(user);
    }

    @Override
    public User getMyself() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println((String) authentication.getPrincipal());
        return ((UserDetailModel) loadUserByUsername((String) authentication.getPrincipal())).getUser();
    }

    private UserModel toModel(User user){
        return UserModel.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .role(user.getAuthority())
                .phone(user.getPhone())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user =userRepository.findUserByEmail(email)
                .orElseThrow(() -> new UserException("User not found"));
        return new UserDetailModel(user);
    }
}
