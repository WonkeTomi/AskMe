package com.askme.AskMe.controller;

import com.askme.AskMe.controller.request.QuestionRequest;
import com.askme.AskMe.model.Client;
import com.askme.AskMe.model.Question;
import com.askme.AskMe.services.ClientServices;
import com.askme.AskMe.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;
    private final ClientServices clientServices;

    @GetMapping
    public List<Question> getAllQuestion() {
        return questionService.findAllQuestion();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addQuestion(@RequestBody QuestionRequest request) {
        Client client = clientServices.getClientById(request.clientId);
        Question question = Question.builder()
                .client(client)
                .question(request.question)
                .date(request.getDate())
                .build();

        try {
            questionService.saveQuestion(question);
            return ResponseEntity.ok("Question get uploaded");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateQuestion(@RequestBody Map<String, String> data) {
        try {
            questionService.updateQuestion(parseLong(data.get("questionId")), data.get("question"));
            return ResponseEntity.ok("Your question successfully updated");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/delete")
    public void deleteQuestion(@RequestBody Long id) {
        questionService.deleteQuestion(id);
    }
}
