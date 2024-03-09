package edu.java.controller;

import edu.java.client.StackOverflowClient;
import edu.java.dto.StackOverflowResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stackoverflow")
public class StackOverflowController {

    private final StackOverflowClient stackOverflowClient;

    @GetMapping("/question/{questionId}")
    public StackOverflowResponse getQuestion(@PathVariable long questionId) {
        return stackOverflowClient.fetchQuestion(questionId);
    }
}
