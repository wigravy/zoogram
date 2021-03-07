package com.wigravy.zoogram.services;

import com.wigravy.zoogram.entities.Role;
import com.wigravy.zoogram.entities.User;
import com.wigravy.zoogram.exceptions.UserCreateException;
import com.wigravy.zoogram.payload.request.RegistrationNewUserRequest;
import com.wigravy.zoogram.repositories.RoleRepo;
import com.wigravy.zoogram.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService {
    private final UserRepo userRepo;
    private final SCryptPasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;

    public User createUser(RegistrationNewUserRequest newUser) {
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setFirstname(newUser.getFirstname());
        user.setLastname(newUser.getLastname());
        user.setNickname(newUser.getNickname());
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setIsActive(true);
        user.setRoles(List.of(roleRepo.findOneByName("USER")));
        try {
            log.info("Created new user with email" + user.getEmail());
            return userRepo.save(user);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new UserCreateException("Error creating a new user");
        }
    }

}
