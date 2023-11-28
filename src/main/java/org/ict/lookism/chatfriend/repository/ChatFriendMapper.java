package org.ict.lookism.chatfriend.repository;

import org.apache.ibatis.annotations.Mapper;
import org.ict.lookism.chatfriend.entity.ChatFriend;

import java.util.List;

@Mapper
public interface ChatFriendMapper {
    public List<ChatFriend> selectAllChatFriend();

    public List<ChatFriend> selectMyChatFriend(String userId);

    public ChatFriend insertChatFriend(ChatFriend chatFriend);

    public int deleteChatFriend(ChatFriend chatFriend);
}
