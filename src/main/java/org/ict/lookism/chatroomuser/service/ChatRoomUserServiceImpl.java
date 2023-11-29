package org.ict.lookism.chatroomuser.service;

import org.ict.lookism.chatroomuser.entity.ChatRoomUser;
import org.ict.lookism.member.vo.MemberVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chatRoomUserService")
public class ChatRoomUserServiceImpl implements ChatRoomUserService{
    @Override
    public List<MemberVo> selectChatRoom(String chatRoomId) {
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
