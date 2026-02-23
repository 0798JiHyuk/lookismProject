package org.ict.lookism.chat.controller;

import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.chat.service.ChatService;
import org.ict.lookism.chat.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    private SimpMessagingTemplate template;

    @MessageMapping("/send/message")
    public void sendMessage(String senderId, String receiverId, String message){
        System.out.println("Received Message: "+ message);
        this.template.convertAndSend("/message",  message);
    }

    @PostMapping
    public ResponseEntity<String> insertChat(String senderId , String receiverID) throws Exception{
        return null;
    }

    @GetMapping("/sended/{senderId}")
    public List<Chat> selectAllSendChat(String senderId){
        return null;
    }

    @GetMapping("/received/{receiverId}")
    public List<Chat> selectAllRecvChat(String receiverId){
        return null;
    }

    @GetMapping("/aftertime/{timestamp}")
    public List<Chat> selectAllChatAfterTime(Timestamp timestamp){
        return null;
    }

    @DeleteMapping("/del/{chatId}")
    public int deleteChat(String chatId){
        return 0;
    }
}

