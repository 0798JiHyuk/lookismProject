package org.ict.lookism.files.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Files {
    private String fileId;
    private String userId;
    private String boardId;
    private String boardName;
    private String fileName;
    private Timestamp regDate;
    private String delYn;
    private String delDate;
}
