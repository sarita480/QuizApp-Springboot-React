package com.sarita.quizapp.service;

import com.sarita.quizapp.entity.Question;
import com.sarita.quizapp.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService
{
    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<List<Question>> getAllQuestion()
    {
        try
        {
            return new ResponseEntity<>(questionRepository.findAll(), HttpStatus.OK);
        } catch(Exception e)
        {
                e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
        try
        {


            return new ResponseEntity<>(questionRepository.findByCategory(category), HttpStatus.OK);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        try
        {
            questionRepository.save(question);
            return new ResponseEntity<>("Question is added successfully", HttpStatus.CREATED);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
    }
    public  String deleteQuestion(Integer id)
    {
        Optional<Question> question = questionRepository.findById(id);
       if( question.isPresent())
       {
          Question questionEn =  question.get();
          questionRepository.delete(questionEn);
           return "deleted";
       }
       else
           return "Id does not exist.";


    }

}
