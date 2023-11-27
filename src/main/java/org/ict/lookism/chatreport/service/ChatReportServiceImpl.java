package org.ict.lookism.chatreport.service;

import org.ict.lookism.chatreport.mapper.ChatReportMapper;
import org.ict.lookism.chatreport.vo.ChatReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("chatReportService")
@Transactional
public class ChatReportServiceImpl implements ChatReportService{
    @Autowired
    private ChatReportMapper chatReportMapper;

    @Override
    public List<ChatReport> selectAllChatReport() {
        return null;
    }

    @Override
    public List<ChatReport> selectAllChatReporter(String ChatReporterId) {
        return null;
    }

    @Override
    public List<ChatReport> selectAllChatUserId(String UserId) {
        return null;
    }

    @Override
    public int insertChatReport(ChatReport chatReport) {
        return 0;
    }

    @Override
    public int updateChatReport(ChatReport chatReport) {
        return 0;
    }

    @Override
    public int deleteChatReport(String chatReportId) {
        return 0;
    }
}
