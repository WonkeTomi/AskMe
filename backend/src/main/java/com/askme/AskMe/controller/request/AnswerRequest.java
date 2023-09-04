package com.askme.AskMe.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class AnswerRequest {

    public Long questionId;
    public String answer;
    LocalDate date;
}
