package com.askme.AskMe.services;

import com.askme.AskMe.model.Answer;
import com.askme.AskMe.repository.AnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;

    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public Answer findAnswerById(Long id) {
        return answerRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Answer> findAnswersToAQuestion(Long questionId) {
        return answerRepository.findAllByQuestionId(questionId);
    }

    public void updateAnswer(Long id, String answer) {
        Answer answerToUpdate = findAnswerById(id);
        answerToUpdate.setAnswer(answer);
        answerRepository.save(answerToUpdate);
    }

    public void deleteAnswerById(Long id) {
        Answer answerToDelete = findAnswerById(id);
        answerRepository.delete(answerToDelete);
    }
}
