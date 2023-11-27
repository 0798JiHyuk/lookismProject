package org.ict.lookism.chatroom.service;

import org.ict.lookism.chatroom.mapper.ChatRoomMapper;
import org.ict.lookism.chatroom.vo.ChatRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chatRoomService")
@Transactional
public class ChatRoomServiceImpl implements ChatRoomService{
    @Autowired
    private ChatRoomMapper chatRoomMapper;

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
