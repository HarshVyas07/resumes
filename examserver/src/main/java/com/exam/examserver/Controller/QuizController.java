package com.exam.examserver.Controller;

import java.util.List;

import com.exam.examserver.Model.Exam.Category;
import com.exam.examserver.Model.Exam.Quiz;
import com.exam.examserver.Services.QuizServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {
    @Autowired 
    private QuizServiceImpl quizServiceImpl;

    @PostMapping("/")
    public ResponseEntity<?> addQuiz(@RequestBody Quiz quiz){
        Quiz quiz1= this.quizServiceImpl.addQuiz(quiz);
        return ResponseEntity.ok(quiz1);
    }
    //get category
    @GetMapping("/{quizId}")
    public Quiz getQuiz(@PathVariable("quizId") Long quizid){
        return this.quizServiceImpl.getQuiz(quizid);
    }
    //get all category
    @GetMapping("/")
    public ResponseEntity<?> getAllQuiz(){
        return ResponseEntity.ok(this.quizServiceImpl.getQuizess());
    }
    //update
    @PutMapping("/")
    public Quiz updateQuiz(@RequestBody Quiz quiz){
        return this.quizServiceImpl.updateQuiz(quiz);
    }

    // Delete 
    @DeleteMapping("/{quizid}")
    public void deleteQuiz(@PathVariable("quizid") Long quizid){
        this.quizServiceImpl.deleteQuiz(quizid);    
    }

    @GetMapping("/category/{cid}")
    public List<Quiz> getQuizofCategory(@PathVariable("cid") Long cid){
        Category category= new Category();
        category.setCid(cid);
        return this.quizServiceImpl.getQuizofCategory(category);    
    }

    // get active quiz
    @GetMapping("/active")
    public List<Quiz> getActiveQuiz(){
        return this.quizServiceImpl.getActiveQuizes();
    } 
    //get active quiz of category
    @GetMapping("/category/active/{cid}")
    public List<Quiz> getActiveQuizCategory(@PathVariable("cid") Long cid){
        Category category= new Category();
        category.setCid(cid);
        return this.quizServiceImpl.getActiveQuizOfCategory(category); 
    } 
}
