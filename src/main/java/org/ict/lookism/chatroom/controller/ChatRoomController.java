package org.ict.lookism.chatroom.controller;

import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.chatroom.service.ChatRoomService;
import org.ict.lookism.chatroom.entity.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chatroom")
public class ChatRoomController {
    @Autowired
    private ChatRoomService chatRoomService;

    @GetMapping
    public ResponseEntity<List<ChatRoom>> selectAllChatRoom(){
        return null;
    }

    @PutMapping("/{chatRoomId")
    public ResponseEntity<ChatRoom> updateChatRoom(ChatRoom chatRoom){
        return null;
    }

    @PostMapping
    public String insertChatRoom(ChatRoom chatRoom){
        return "";
    }

    @DeleteMapping("/{chatRoomId}")
    public String deleteChatRoom(String chatRoomId){
        return "";
    }
}
