package com.askme.AskMe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Answer {

    @Id
    private Long id;

    @Column
    private String answer;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @Column
    private LocalDate date;
}
