package com.askme.AskMe.controller;

import com.askme.AskMe.model.Question;
import com.askme.AskMe.services.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public List<Question> getAllQuestion() {
        return questionService.findAllQuestion();
    }

//    @PostMapping("/add")
//    public ResponseEntity<?> addQuestion(@RequestBody Map<Long, String> data) {
//
//    }
}
