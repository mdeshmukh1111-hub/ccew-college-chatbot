package com.ccew.collegechatbot.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ChatController {

    @PostMapping("/chat")
    public ChatResponse chat(@RequestBody ChatRequest request) {

        return new ChatResponse(
            "NEW CONTROLLER IS WORKING: " + request.getMessage()
        );
    }

    public static class ChatRequest {

        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    public static class ChatResponse {

        private String response;

        public ChatResponse(String response) {
            this.response = response;
        }

        public String getResponse() {
            return response;
        }
    }
}