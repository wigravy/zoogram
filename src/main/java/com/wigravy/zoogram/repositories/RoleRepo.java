package com.wigravy.zoogram.repositories;

import com.wigravy.zoogram.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Byte> {
    Role findOneByName(String name);
}
