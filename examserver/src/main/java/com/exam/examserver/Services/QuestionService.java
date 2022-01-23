package com.exam.examserver.Services;

import java.util.Set;

import com.exam.examserver.Model.Exam.Question;
import com.exam.examserver.Model.Exam.Quiz;

public interface QuestionService {
    public Question addQuestion(Question question);
    public Question updatQuestion(Question question);
    public Set<Question> getQuestions();
    public Question getQuestion(Long quesid);
    public Set<Question> gQuestionsOfQuiz(Quiz quiz);
    public void deleteQuestion(Long quesid);
}
