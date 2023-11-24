package org.ict.lookism.chat.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ict.lookism.chat.vo.Chat;

import java.sql.Timestamp;
import java.util.List;

@Mapper
public interface ChatMapper {
    public List<Chat> selectAllSendChat(String senderId);

    public List<Chat> selectAllRecvChat(String receiverId);

    public List<Chat> selectAllChatAfterTime(Timestamp timestamp);

    public int insertChat(Chat chat);

    public int deleteChat(String chatId);
}
