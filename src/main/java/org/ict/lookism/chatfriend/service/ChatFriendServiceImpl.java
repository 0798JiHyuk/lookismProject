package org.ict.lookism.chatfriend.service;

import org.ict.lookism.chatfriend.repository.ChatFriendRepository;
import org.ict.lookism.chatfriend.entity.ChatFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chatFriendService")
@Transactional
public class ChatFriendServiceImpl implements ChatFriendService{


    @Override
    public List<ChatFriend> selectAllChatFriend() {
        return null;
    }

    @Override
    public List<ChatFriend> selectMyChatFriend(String userId) {
        return null;
    }

    @Override
    public ChatFriend insertChatFriend(ChatFriend chatFriend) {
        return null;
    }

    @Override
    public int deleteChatFriend(ChatFriend chatFriend) {
        return 0;
    }
}
