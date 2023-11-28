package org.ict.lookism.board.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    private String boardid;
    private String boardtitle;
    private String boardname;
    private String boardbody;
    private String userid;
    private java.time.LocalDateTime writedate;
    private java.time.LocalDateTime modifydate;
    private int readcount;
    private String repyn;
    private String originid;
    private String reportyn;
    private String hashtag;


}