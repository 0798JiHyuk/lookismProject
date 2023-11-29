package org.ict.lookism.member.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberVo {
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
