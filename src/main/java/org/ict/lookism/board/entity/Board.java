package org.ict.lookism.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data  // @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor 모두 사용한 것과 같음
@NoArgsConstructor
@AllArgsConstructor
public class Board /* implements java.io.Serializable */ {
	//private static final long serialVersionUID = -5219066150385199445L;
	private String boardId;
	private String boardTitle;
	private String boardName;
	private String boardBody;
	private String userId;
	private Timestamp writeDate;
	private Timestamp modifyDate;
	private int readCount;
	private String repYn;
	private String originId;
	private String reportYn;
	private String hashTag;
	private String boardType;
	private String userName;
}
