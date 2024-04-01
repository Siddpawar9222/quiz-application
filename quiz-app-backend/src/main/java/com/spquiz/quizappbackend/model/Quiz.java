package com.spquiz.quizappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long quizId;
    private String title;
    private  Boolean isActive ;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="quiz_ques",joinColumns = @JoinColumn(name = "quiz_id"),inverseJoinColumns = @JoinColumn(name = "que_id"))
    private List<Question> questions;
}
