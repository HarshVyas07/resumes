package com.exam.examserver.Repository;

import com.exam.examserver.Model.Exam.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    
}
