package org.ict.lookism.chatreport.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatReport {
    private String ChatReportId;
    private String ChatReport;
    private String ChatReporterId;
    private Timestamp ChatReportDate;
    private String ChatLog;
    private String userId;
}
