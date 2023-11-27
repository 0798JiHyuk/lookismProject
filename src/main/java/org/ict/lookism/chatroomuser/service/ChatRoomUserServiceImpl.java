package org.ict.lookism.chatroomuser.service;

import org.ict.lookism.Member.vo.Member;
import org.ict.lookism.chatroomuser.mapper.ChatRoomUserMapper;
import org.ict.lookism.chatroomuser.vo.ChatRoomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chatRoomUserService")
@Transactional
public class ChatRoomUserServiceImpl implements ChatRoomUserService{
    @Autowired
    private ChatRoomUserMapper chatRoomUserMapper;
    @Override
    public List<Member> selectChatRoom(String chatRoomId) {
        return null;
    }

    @Override
    public int insertChatRoomUser(ChatRoomUser chatRoomUser) {
        return 0;
    }

    @Override
    public int deleteChatRoomUser(ChatRoomUser chatRoomUser) {
        return 0;
    }
}
