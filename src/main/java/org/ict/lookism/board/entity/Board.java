package org.ict.lookism.board.entity;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Board")
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOARDID")
	private String boardid;

	@Column(name = "BOARDTITLE")
	private String boardtitle;

	@Column(name = "BOARDNAME")
	private String boardname;

	@Column(name = "BOARDBODY")
	private String boardbody;

	@Column(name = "USERID")
	private String userid;

	@Column(name = "WRITEDATE")
	private Date writedate;

	@Column(name = "MODIFYDATE")
	private Date modifydate;

	@Column(name = "READCOUNT")
	private int readcount;

	@Column(name = "REPYN")
	private String repyn;

	@Column(name = "ORIGINID")
	private String originid;

	@Column(name = "REPORTYN")
	private String reportyn;

	@Column(name = "HASHTAG")
	private String hashtag;

}
