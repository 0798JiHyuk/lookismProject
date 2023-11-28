package org.ict.lookism.chatroomuser.repository;

import org.apache.ibatis.annotations.Mapper;
import org.ict.lookism.member.vo.Member;
import org.ict.lookism.chatroomuser.entity.ChatRoomUser;

import java.util.List;

@Mapper
public interface ChatRoomUserMapper {

    public List<Member> selectChatRoom(String chatRoomId);

    public int insertChatRoomUser(ChatRoomUser chatRoomUser);

    public int deleteChatRoomUser(ChatRoomUser chatRoomUser);

}
