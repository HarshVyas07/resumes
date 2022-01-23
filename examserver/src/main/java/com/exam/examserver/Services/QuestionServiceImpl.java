package com.exam.examserver.Services;

import java.util.HashSet;
import java.util.Set;

import com.exam.examserver.Model.Exam.Question;
import com.exam.examserver.Model.Exam.Quiz;
import com.exam.examserver.Repository.QuestionRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepo questionRepo;

    @Override
    public Question addQuestion(Question question) {
       return this.questionRepo.save(question);
    }

    @Override
    public Question updatQuestion(Question question) {    
       return this.questionRepo.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepo.findAll());  
    }

    @Override
    public Question getQuestion(Long quesid) {
       return this.questionRepo.findById(quesid).get();
    }

    @Override
    public Set<Question> gQuestionsOfQuiz(Quiz quiz) {
      return this.questionRepo.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesid) {
      this.questionRepo.deleteById(quesid);
    }
    
}
