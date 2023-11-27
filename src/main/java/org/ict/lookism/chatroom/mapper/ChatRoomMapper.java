package org.ict.lookism.chatroom.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ict.lookism.chat.vo.Chat;
import org.ict.lookism.chatroom.vo.ChatRoom;

import java.util.List;

@Mapper
public interface ChatRoomMapper {

    public List<ChatRoom> selectAllChatRoom();

    public ChatRoom updateChatRoom(ChatRoom chatRoom);

    public int insertChatRoom(ChatRoom chatRoom);

    public int deleteChatRoom(String chatRoomId);


}
