package org.ict.lookism.member.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.Instant;
import org.ict.lookism.member.controller.SignupRequest;

@Entity
@Table(name = "lookism_members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 254)
    private String email;

    @Column(nullable = false, length = 60)
    private String passwordHash;

    @Column(nullable = false, length = 80)
    private String name;

    @Column(nullable = false)
    private Instant enrolledAt;

    private LocalDate birth;
    private String phone;
    private Integer height;
    private Integer weight;
    private String cigarette;
    private String drinking;
    private String religion;
    private String mbti;

    @Column(length = 500)
    private String profile;

    protected Member() {}

    public Member(String email, String passwordHash, SignupRequest request) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.name = request.userName().trim();
        this.enrolledAt = Instant.now();
        this.birth = request.userBirth();
        this.phone = request.userPhone();
        this.height = request.userHeight();
        this.weight = request.userWeight();
        this.cigarette = request.userCigarette();
        this.drinking = request.userDrinking();
        this.religion = request.userReligion();
        this.mbti = request.userMBTI();
        this.profile = request.userProfile();
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public String getName() { return name; }
}
