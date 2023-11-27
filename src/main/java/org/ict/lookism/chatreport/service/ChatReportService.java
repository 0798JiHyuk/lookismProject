package org.ict.lookism.chatreport.service;

import org.ict.lookism.chatreport.vo.ChatReport;

import java.util.List;

public interface ChatReportService {
    public List<ChatReport> selectAllChatReport();

    public List<ChatReport> selectAllChatReporter(String ChatReporterId);

    public List<ChatReport> selectAllChatUserId(String UserId);

    public int insertChatReport(ChatReport chatReport);

    public int updateChatReport(ChatReport chatReport);

    public int deleteChatReport(String chatReportId);


}
