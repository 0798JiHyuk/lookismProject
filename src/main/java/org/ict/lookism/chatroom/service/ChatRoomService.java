package org.ict.lookism.chatroom.service;

import org.ict.lookism.chatroom.vo.ChatRoom;

import java.util.List;

public interface ChatRoomService {
    public List<ChatRoom> selectAllChatRoom();

    public ChatRoom updateChatRoom(ChatRoom chatRoom);

    public int insertChatRoom(ChatRoom chatRoom);

    public int deleteChatRoom(String chatRoomId);

}
