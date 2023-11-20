package com.academy.airline.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academy.airline.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
}
