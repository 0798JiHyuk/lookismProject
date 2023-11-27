package org.ict.lookism.chat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    private String chatId;
    private String senderId;
    private String receiverId;
    private Timestamp chatTime;
    private Timestamp chatEndTime;
}
