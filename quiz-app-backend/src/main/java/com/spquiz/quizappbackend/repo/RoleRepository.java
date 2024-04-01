package com.spquiz.quizappbackend.repo;

import com.spquiz.quizappbackend.model.ERole;
import com.spquiz.quizappbackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}
