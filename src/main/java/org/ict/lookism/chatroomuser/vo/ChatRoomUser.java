package org.ict.lookism.chatroomuser.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatRoomUser {
    private String userId;
    private String chatRoomId;
    private Timestamp entranceTime;
    private Timestamp exitTime;
}
