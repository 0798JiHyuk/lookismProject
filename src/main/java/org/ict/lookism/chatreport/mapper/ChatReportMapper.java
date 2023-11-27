package org.ict.lookism.chatreport.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.ict.lookism.chat.vo.Chat;
import org.ict.lookism.chatreport.vo.ChatReport;

import java.util.List;

@Mapper
public interface ChatReportMapper {

    public List<ChatReport> selectAllChatReport();

    public List<ChatReport> selectAllChatReporter(String ChatReporterId);

    public List<ChatReport> selectAllChatUserId(String UserId);

    public int insertChatReport(ChatReport chatReport);

    public int updateChatReport(ChatReport chatReport);

    public int deleteChatReport(String chatReportId);


}
