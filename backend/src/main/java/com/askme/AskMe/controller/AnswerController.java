package com.askme.AskMe.controller;

import com.askme.AskMe.controller.request.AnswerRequest;
import com.askme.AskMe.model.Answer;
import com.askme.AskMe.model.Question;
import com.askme.AskMe.services.AnswerService;
import com.askme.AskMe.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("/answer")
@AllArgsConstructor
public class AnswerController {

    private final AnswerService answerService;
    private final QuestionService questionService;

    @GetMapping("/{answerId}")
    public Answer getAnswerById(@PathVariable Long answerId) {
        return answerService.findAnswerById(answerId);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addAnswer(@RequestBody AnswerRequest request) {
        Question question = questionService.findQuestionById(request.questionId);
        Answer answer = Answer.builder()
                .question(question)
                .answer(request.answer)
                .date(request.getDate())
                .build();
        try {
            answerService.saveAnswer(answer);
            return ResponseEntity.ok("Answer get uploaded");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateAnswer(@RequestBody Map<String, String> data) {
        try {
            answerService.updateAnswer(parseLong(data.get("answerId")), data.get("answer"));
            return ResponseEntity.ok("Your answer get updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete")
    public void deleteAnswer(@RequestBody Long id) {
        answerService.deleteAnswerById(id);
    }
}
