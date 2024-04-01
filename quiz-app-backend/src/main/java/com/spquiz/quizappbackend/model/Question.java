package com.spquiz.quizappbackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long queId;
    private String text;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="ques_ans",joinColumns = @JoinColumn(name = "que_id"),inverseJoinColumns = @JoinColumn(name = "ans_id"))
     private List<Answer> answers;
}
