package com.sarita.quizapp.controller;

import com.sarita.quizapp.entity.Question;
import com.sarita.quizapp.entity.Quiz;
import com.sarita.quizapp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController
{
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title)
    {
        return quizService.createQuiz(category, numQ, title);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<List<Question>> getQuizQuestion(@PathVariable("id") Integer id)
    {

    }


}
