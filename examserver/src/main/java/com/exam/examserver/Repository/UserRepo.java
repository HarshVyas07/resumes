package com.exam.examserver.Repository;

import com.exam.examserver.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

   public User findByUsername(String username);

    
}
