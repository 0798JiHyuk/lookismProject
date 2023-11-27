package org.ict.lookism.chatroomuser.service;

import org.ict.lookism.Member.vo.Member;
import org.ict.lookism.chatroomuser.entity.ChatRoomUser;

import java.util.List;

public interface ChatRoomUserService {

    public List<Member> selectChatRoom(String chatRoomId);

    public int insertChatRoomUser(ChatRoomUser chatRoomUser);

    public int deleteChatRoomUser(ChatRoomUser chatRoomUser);

}
