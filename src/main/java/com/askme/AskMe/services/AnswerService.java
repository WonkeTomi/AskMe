package com.askme.AskMe.services;

import com.askme.AskMe.model.Answer;
import com.askme.AskMe.repository.AnswerRepository;
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
        return answerRepository.findById(id).orElse(null);
    }

    public List<Answer> findAnswersToAQuestion(Long questionId) {
        return answerRepository.findAllByQuestionId(questionId);
    }

    public void updateAnswer(Long id, String answer) throws Exception {
        Answer answerToUpdate = findAnswerById(id);
        if (answerToUpdate != null) {
            answerToUpdate.setAnswer(answer);
            answerRepository.save(answerToUpdate);
        } else {
            throw new Exception("Didn't find that answer.");
        }
    }

    public void deleteAnswerById(Long id) {
        Answer answerToDelete = findAnswerById(id);
        answerRepository.delete(answerToDelete);
    }
}
