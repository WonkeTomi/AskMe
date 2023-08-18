package com.askme.AskMe.services;

import com.askme.AskMe.model.Question;
import com.askme.AskMe.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public Question findQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    public List<Question> findAllQuestion() {
        return questionRepository.findAll();
    }

    public void saveQuestion(Question question) {
        questionRepository.save(question);
    }

    public void updateQuestion(Long id, String question) throws Exception {
        Question questionToUpdate = findQuestionById(id);
        if (questionToUpdate != null) {
            questionToUpdate.setQuestion(question);
            questionRepository.save(questionToUpdate);
        } else {
            throw new Exception("Didn't find the question");
        }
    }

    public void deleteQuestion(Long id) {
        Question questionToDelete = findQuestionById(id);
        questionRepository.delete(questionToDelete);
    }
}
