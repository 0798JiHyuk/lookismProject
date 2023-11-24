package org.ict.lookism.chat.controller;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.chat.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {
    private ChatService chatService;

    @PostMapping
    public ResponseEntity<String> insertChat(String senderId , String receiverID) throws Exception{
        return null;
    }
}

