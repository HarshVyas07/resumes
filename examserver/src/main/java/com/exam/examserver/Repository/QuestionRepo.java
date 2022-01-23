package com.exam.examserver.Repository;

import java.util.Set;

import com.exam.examserver.Model.Exam.Question;
import com.exam.examserver.Model.Exam.Quiz;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question, Long> {

    public Set<Question> findByQuiz(Quiz quiz);
    
}
