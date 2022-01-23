package com.exam.examserver.Repository;

import com.exam.examserver.Model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    
}
