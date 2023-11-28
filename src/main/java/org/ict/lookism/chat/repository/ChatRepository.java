package org.ict.lookism.chat.repository;

import org.ict.lookism.chat.entity.Chat;

import java.sql.Timestamp;
import java.util.List;

public interface ChatRepository {
    public List<Chat> selectAllSendChat(String senderId);

    public List<Chat> selectAllRecvChat(String receiverId);

    public List<Chat> selectAllChatAfterTime(Timestamp timestamp);

    public int insertChat(Chat chat);

    public int deleteChat(String chatId);
}
