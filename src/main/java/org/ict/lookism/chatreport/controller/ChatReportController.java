package org.ict.lookism.chatreport.controller;

import lombok.extern.slf4j.Slf4j;
import org.ict.lookism.chatreport.service.ChatReportService;
import org.ict.lookism.chatreport.entity.ChatReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/chatreport")
public class ChatReportController {
    @Autowired
    private ChatReportService chatReportService;

    @PostMapping
    public ResponseEntity<ChatReport> insertChatReport(@Validated @RequestBody ChatReport chatReport) throws Exception {
        return null;
    }

    @GetMapping("/{chatReporterId}")
    public List<ChatReport> selectAllChatReporter(String chatReporterId){
        return null;
    }

    @PutMapping("/{chatReportId}")
    public ChatReport updateChatReport(@Validated @RequestBody ChatReport chatReport){
        return null;
    }

    @DeleteMapping("/{chatReportId")
    public int deleteChatReport(String chatReportId){
        return 0;
    }
}
