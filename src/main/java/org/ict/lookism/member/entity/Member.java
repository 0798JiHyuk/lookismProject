package org.ict.lookism.member.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data  // @ToString, @EqualsAndHashCode, @Getter/@Setter, @RequiredArgsConstructor 모두 사용한 것과 같음
@NoArgsConstructor
@AllArgsConstructor
@Builder                              // 클래스로 컴파일 되라.
@Table(name = "Member")                // 자동으로 생성될 테이블 이름이 BOARD 이다
@Entity
public class Member /* implements java.io.Serializable */ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private String userId;
	@Column(name="userPwd")
	private String userPwd;
	@Column(name="userName")
	private String userName;
	@Column(name="userBirth")
	private Date userBirth;
	@Column(name="userEnrolldate")
	private Date userEnrolldate;
	@Column(name="userEmail")
	private String userEmail;
	@Column(name="userHeight")
	private int userHeight;
	@Column(name="userPhone")
	private String userPhone;
	@Column(name="userWeight")
	private int userWeight;
	@Column(name="userCigarette")
	private String userCigarette;
	@Column(name="userDrinking")
	private String userDrinking;
	@Column(name="userReligion")
	private String userReligion;
	@Column(name="userProfile")
	private String userProfile;
	@Column(name="userMBTI")
	private String userMBTI;
	@Column(name="userLevel")
	private String userLevel;
	@Column(name="adminLV")
	private String adminLV;

}
