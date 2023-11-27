package org.ict.lookism.chatroom.repository;

import org.apache.ibatis.annotations.Mapper;
import org.ict.lookism.chatroom.entity.ChatRoom;

import java.util.List;

@Mapper
public interface ChatRoomMapper {

    public List<ChatRoom> selectAllChatRoom();

    public ChatRoom updateChatRoom(ChatRoom chatRoom);

    public int insertChatRoom(ChatRoom chatRoom);

    public int deleteChatRoom(String chatRoomId);


}
