package com.askme.AskMe.services;

import com.askme.AskMe.model.Question;
import com.askme.AskMe.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question findQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }
}
