package org.ict.lookism.chat.service;

import org.ict.lookism.chat.repository.ChatRepository;
import org.ict.lookism.chat.entity.Chat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service("chatService")
public class ChatServiceImpl implements ChatService{
    private ChatRepository chatRepository;

    @Override
    public List<Chat> selectAllSendChat(String senderId) {
        return null;
    }

    @Override
    public List<Chat> selectAllRecvChat(String receiverId) {
        return null;
    }

    @Override
    public List<Chat> selectAllChatAfterTime(Timestamp timestamp) {
        return null;
    }

    @Override
    public int insertChat(Chat chat) {
        return 0;
    }

    @Override
    public int deleteChat(String chatId) {
        return 0;
    }
}
