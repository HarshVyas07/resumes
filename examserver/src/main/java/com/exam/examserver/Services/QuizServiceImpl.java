package com.exam.examserver.Services;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.exam.examserver.Model.Exam.Category;
import com.exam.examserver.Model.Exam.Quiz;
import com.exam.examserver.Repository.QuizRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService  {
    @Autowired
    private QuizRepo quizRepo;

    @Override
    public Quiz addQuiz(Quiz quiz) {
       return this.quizRepo.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
       return this.quizRepo.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizess() {
       return new LinkedHashSet<>(this.quizRepo.findAll());
    }

    @Override
    public Quiz getQuiz(Long qid) {
       return this.quizRepo.findById(qid).get(); 
    }

    @Override
    public void deleteQuiz(Long qid) {
      //   Quiz quiz=new Quiz();
      //   quiz.setQid(qid);
        this.quizRepo.deleteById(qid);
        
    }

    public List<Quiz> getQuizofCategory(Category category){
       return this.quizRepo.findByCategory(category);
   }

   @Override
   public List<Quiz> getActiveQuizes() {
      return this.quizRepo.findByActive(true);
   }

   @Override
   public List<Quiz> getActiveQuizOfCategory(Category c) {
    return this.quizRepo.findByCategoryAndActive(c, true);
   }

  
   
    
}
