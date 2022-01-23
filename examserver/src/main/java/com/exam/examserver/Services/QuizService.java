package com.exam.examserver.Services;

import java.util.List;
import java.util.Set;

import com.exam.examserver.Model.Exam.Category;
import com.exam.examserver.Model.Exam.Quiz;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);
    public Quiz updateQuiz(Quiz quiz);
    public Set<Quiz> getQuizess();
    public Quiz getQuiz(Long qid);
    public void deleteQuiz(Long qid);
    public List<Quiz> getQuizofCategory(Category category);
    public List<Quiz> getActiveQuizes();
    public List<Quiz> getActiveQuizOfCategory(Category c);
}
