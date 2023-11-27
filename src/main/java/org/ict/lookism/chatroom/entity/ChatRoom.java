package org.ict.lookism.chatroom.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoom {
    private String chatRoomId;
    private String chatRoomName;
    private Timestamp chatRoomStrat;
    private Timestamp chatRoomEnd;
    private int chatRoomLimit;
}
