package org.ict.lookism.chatfriend.service;

import org.ict.lookism.chatfriend.vo.ChatFriend;

import java.util.List;

public interface ChatFriendService {
    public List<ChatFriend> selectAllChatFriend();

    public List<ChatFriend> selectMyChatFriend(String userId);

    public ChatFriend insertChatFriend(ChatFriend chatFriend);

    public int deleteChatFriend(ChatFriend chatFriend);

}
