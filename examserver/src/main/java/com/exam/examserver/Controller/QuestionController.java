package com.exam.examserver.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.exam.examserver.Model.Exam.Question;
import com.exam.examserver.Model.Exam.Quiz;
import com.exam.examserver.Services.QuestionServiceImpl;
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
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl quesServiceImpl;

    @Autowired
    private QuizServiceImpl quizServiceImpl;

    @PostMapping("/")
    public ResponseEntity<?> addQuestion(@RequestBody Question question) {
        Question question1 = this.quesServiceImpl.addQuestion(question);
        return ResponseEntity.ok(question1);
    }

    // update
    @PutMapping("/")
    public Question updatQuestion(@RequestBody Question question) {
        return this.quesServiceImpl.updatQuestion(question);
    }

    // get all question of quiz
    @GetMapping("/quiz/{quizid}")
    public ResponseEntity<?> getQuesOfQuiz(@PathVariable("quizid") Long quizid) {
        // Quiz quiz = new Quiz();
        // quiz.setQid(quizid);
        // Set<Question> quesOfQuiz= this.quesServiceImpl.gQuestionsOfQuiz(quiz);
        // return ResponseEntity.ok(quesOfQuiz);
        Quiz quiz = this.quizServiceImpl.getQuiz(quizid);
        Set<Question> quesOfQuiz = quiz.getQuestions();
        List list = new ArrayList(quesOfQuiz);
        if (list.size() > Integer.parseInt(quiz.getNoOfQuestion())) {
            list.subList(0, Integer.parseInt(quiz.getNoOfQuestion() + 1));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/quiz/all/{quizid}")
    public ResponseEntity<?> getQuesOfQuizAdmin(@PathVariable("quizid") Long quizid) {
        Quiz quiz = new Quiz();
        quiz.setQid(quizid);
        Set<Question> quesOfQuiz = this.quesServiceImpl.gQuestionsOfQuiz(quiz);
        return ResponseEntity.ok(quesOfQuiz);
    }

    // get single qsn
    @GetMapping("/{quesid}")
    public Question getQuestion(@PathVariable("quesid") Long quesid) {
        return this.quesServiceImpl.getQuestion(quesid);
    }

    // delete
    @DeleteMapping("/{quesid}")
    public void deleteQues(@PathVariable("quesid") Long quesid) {
        this.quesServiceImpl.deleteQuestion(quesid);
    }

    // evaluate quiz
    @PostMapping("/eval-quiz")
    public ResponseEntity<?> evalQuiz(@RequestBody List<Question> questions) {
        // System.out.println(questions);
        Double marksGot = 0.0;
        Integer correctAnswers = 0;
        Integer attemptedQsn = 0;
        for (Question q : questions) {
            Question question = this.quesServiceImpl.getQuestion(q.getQuesid());
            if (question.getAnswer().equals(q.getGivenAnswer())) {
                correctAnswers++;
                double markssingle = Double.parseDouble(questions.get(0).getQuiz().getMaxMarks())/questions.size(); 
                marksGot+=markssingle;
            } 
            if(q.getGivenAnswer()!= null){
                attemptedQsn++;
            }
        } 
        Map<String,Object> map = Map.of("marksGot",marksGot,"correctAnswers",correctAnswers,"attemptedQsn",attemptedQsn);
        return ResponseEntity.ok(map);
    }
}
