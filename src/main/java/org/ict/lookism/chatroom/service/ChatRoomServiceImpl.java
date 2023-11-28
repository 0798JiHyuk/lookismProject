package org.ict.lookism.chatroom.service;

import org.ict.lookism.chatroom.entity.ChatRoom;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chatRoomService")
@Transactional
public class ChatRoomServiceImpl implements ChatRoomService{

    @Override
    public List<ChatRoom> selectAllChatRoom() {
        return null;
    }

    @Override
    public ChatRoom updateChatRoom(ChatRoom chatRoom) {
        return null;
    }

    @Override
    public int insertChatRoom(ChatRoom chatRoom) {
        return 0;
    }

    @Override
    public int deleteChatRoom(String chatRoomId) {
        return 0;
    }
}
