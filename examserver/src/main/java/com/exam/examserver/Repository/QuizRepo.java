package com.exam.examserver.Repository;

import java.util.List;

import com.exam.examserver.Model.Exam.Category;
import com.exam.examserver.Model.Exam.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz, Long> {
      public List<Quiz> findByCategory(Category category);
      public List<Quiz> findByActive(Boolean b);
      public List<Quiz> findByCategoryAndActive(Category category, Boolean b);  
}
