package com.spquiz.quizappbackend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "role_id")
    private Integer id ;


    @Column(name = "role_name")
    @Enumerated(EnumType.ORDINAL)
    private ERole name ;


    private  String description ;
}
