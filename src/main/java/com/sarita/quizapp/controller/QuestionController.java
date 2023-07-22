package com.sarita.quizapp.controller;

import com.sarita.quizapp.entity.Question;
import com.sarita.quizapp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController
{
    @Autowired
    QuestionService questionService;
    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>>getAllQuestions()
    {
        return questionService.getAllQuestion();

    }
    @GetMapping("/category/{category}")
    /*if the name is different in the url then we have to mention it in the method
    like this (@PathVariable("cat") but since they are same in this case we don't need to do that here.
    */

    public ResponseEntity<List<Question>>getQuestionCategory(@PathVariable String category)
    {
        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("/add")
    public ResponseEntity<String>addQuestion(@RequestBody Question question)
    {
        return questionService.addQuestion(question);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id)
    {
       return  questionService.deleteQuestion(id);
    }



}
