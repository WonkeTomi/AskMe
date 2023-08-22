package com.askme.AskMe.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class QuestionRequest {
    public String question;
    public Long clientId;
    LocalDate date;
}
