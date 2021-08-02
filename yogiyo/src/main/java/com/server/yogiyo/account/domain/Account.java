package com.server.yogiyo.account.domain;

import com.server.yogiyo.account.domain.dto.SignUpDto;
import com.server.yogiyo.account.domain.enumtypes.GradeType;
import com.server.yogiyo.account.domain.enumtypes.OAuthType;
import com.server.yogiyo.account.domain.enumtypes.RoleType;
import com.server.yogiyo.configure.entity.BaseTimeEntity;
import com.server.yogiyo.configure.entity.Status;
import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Account extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @Enumerated(EnumType.STRING)
    private Status status;

    private String nickname;

    private String email;

    private String password;

    private String phoneNumber;

    private String profileImage;

    private String generalAddress;

    private String detailedAddress;

    @Enumerated(EnumType.STRING)
    private GradeType grade;

    @Enumerated(EnumType.STRING)
    private OAuthType oAuth;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    private boolean alarmAgree;

    public static Account createAccount(SignUpDto req) {
        return Account.builder()
                .status(Status.Valid)
                .nickname(req.getNickname())
                .email(req.getEmail())
                .password(req.getPassword())
                .grade(GradeType.요기프랜드)
                .oAuth(OAuthType.None)
                .role(RoleType.ROLE_USER)
                .alarmAgree(req.isAlarmAgree())
                .build();
    }

}
