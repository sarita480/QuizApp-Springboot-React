package com.sarita.quizapp.entity;

import jakarta.persistence.*;
import org.aspectj.weaver.patterns.TypePatternQuestions;

@Entity
@Table(name="quiz_questions")
public class QuizQuestion
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="quiz_id")
    private Quiz quiz;
    @ManyToOne
    @JoinColumn(name="question_id", nullable=false)
    private Question question;



}
