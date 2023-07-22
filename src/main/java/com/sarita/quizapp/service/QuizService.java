package com.sarita.quizapp.service;

import com.sarita.quizapp.entity.Question;
import com.sarita.quizapp.entity.Quiz;
import com.sarita.quizapp.repository.QuestionRepository;
import com.sarita.quizapp.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService
{
    @Autowired
    QuizRepository quizRepository;
    @Autowired
    QuestionRepository questionRepository;
    public ResponseEntity<String> createQuiz(String category, int numQ, String title)
    {
        List<Question> questions = questionRepository.findRandomQuestionByCategory(category, numQ);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

}
