package org.ict.lookism.chatroomuser.controller;

import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.Member.vo.Member;
import org.ict.lookism.chatroomuser.service.ChatRoomUserService;
import org.ict.lookism.chatroomuser.entity.ChatRoomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chatroomuser")
public class ChatRoomUserController {
    @Autowired
    private ChatRoomUserService chatRoomUserService;

    @GetMapping("/{chatRoomId}")
    public ResponseEntity<List<Member>> selectChatRoom(String chatRoomId){
        return null;
    }

    @PostMapping("/{chatRoomId}")
    public String insertChatRoomUser(ChatRoomUser chatRoomUser){
        return null;
    }

    @DeleteMapping("/{chatRoomId}")
    public String deleteChatRoomUser(ChatRoomUser chatRoomUser){
        return null;
    }
}
