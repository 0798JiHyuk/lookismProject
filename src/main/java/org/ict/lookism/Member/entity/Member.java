package org.ict.lookism.Member.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data  // @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor 모두 사용한 것과 같음
@NoArgsConstructor
@AllArgsConstructor
public class Member /* implements java.io.Serializable */ {
	//private static final long serialVersionUID = -5219066150385199445L;
	private String userId;
	private String userPwd;
	private String userName;
	private Date userBirth;
	private Date userEnrolldate;
	private String userEmail;
	private int userHeight;
	private String userPhone;
	private int userWeight;
	private String userCigarette;
	private String userDrinking;
	private String userReligion;
	private String userProfile;
	private String userMBTI;
	private String userLevel;
	private String adminLV;
}
