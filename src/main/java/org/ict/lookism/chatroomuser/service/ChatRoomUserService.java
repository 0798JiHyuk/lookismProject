package org.ict.lookism.chatroomuser.service;

import org.ict.lookism.chatroomuser.entity.ChatRoomUser;
import org.ict.lookism.member.vo.MemberVo;

import java.util.List;

public interface ChatRoomUserService {

    public List<MemberVo> selectChatRoom(String chatRoomId);

    public int insertChatRoomUser(ChatRoomUser chatRoomUser);

    public int deleteChatRoomUser(ChatRoomUser chatRoomUser);

}
