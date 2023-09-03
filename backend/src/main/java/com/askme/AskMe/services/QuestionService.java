package com.askme.AskMe.services;

import com.askme.AskMe.model.Question;
import com.askme.AskMe.repository.QuestionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question findQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    public void updateQuestion(Long id, String question) {
        Question questionToUpdate = findQuestionById(id);
        questionToUpdate.setQuestion(question);
        questionRepository.save(questionToUpdate);
    }

    public void deleteQuestion(Long id) {
        Question questionToDelete = findQuestionById(id);
        questionRepository.delete(questionToDelete);
    }
}
