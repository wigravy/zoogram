package com.wigravy.zoogram.services;

import com.wigravy.zoogram.entities.Role;
import com.wigravy.zoogram.repositories.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;

    public Role findByName(String name) {
        return roleRepo.findOneByName(name);
    }
}
