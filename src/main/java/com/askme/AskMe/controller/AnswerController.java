package com.askme.AskMe.controller;

import com.askme.AskMe.controller.request.AnswerRequest;
import com.askme.AskMe.model.Answer;
import com.askme.AskMe.services.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
@AllArgsConstructor
public class AnswerController {

    private final AnswerService answerService;

    @GetMapping("/{answerId}")
    public Answer getAnswerById(@PathVariable Long answerId) {
        return answerService.findAnswerById(answerId);
    }

//    @PostMapping()
//    public ResponseEntity<?> addAnswer(@RequestBody AnswerRequest request) {
//        Answer answer = Answer.builder()
//                .build();
//    }
}
