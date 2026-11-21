package org.ict.lookism.member.controller;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record SignupRequest(
        @NotBlank @Email @Size(max = 254) String userEmail,
        @NotBlank @Size(min = 8, max = 72) String userPwd,
        @NotBlank @Size(max = 80) String userName,
        @Past LocalDate userBirth,
        @Size(max = 30) String userPhone,
        @Min(1) @Max(300) Integer userHeight,
        @Min(1) @Max(500) Integer userWeight,
        @Size(max = 30) String userCigarette,
        @Size(max = 30) String userDrinking,
        @Size(max = 30) String userReligion,
        @Size(max = 4) String userMBTI,
        @Size(max = 500) String userProfile,
        @Size(max = 8) String emailCode
) {}
