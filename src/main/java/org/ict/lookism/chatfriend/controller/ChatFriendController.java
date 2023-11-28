package org.ict.lookism.chatfriend.controller;

import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.chatfriend.service.ChatFriendService;
import org.ict.lookism.chatfriend.entity.ChatFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("chatfriend")
public class ChatFriendController {
    private ChatFriendService chatFriendService;

    @GetMapping("/{userId")
    public ResponseEntity<List<ChatFriend>> selectMyChatFriend(String userId){
        return null;
    }

    public ResponseEntity<ChatFriend> insertChatFriend(ChatFriend chatFriend){
        return null;
    }

    public String deleteChatFriend(ChatFriend chatFriend){
        return "";
    }
}
