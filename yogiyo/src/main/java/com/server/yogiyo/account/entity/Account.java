package com.server.yogiyo.account.entity;

import com.server.yogiyo.account.dto.AccountAuthDto;
import com.server.yogiyo.account.entity.enumtypes.GradeType;
import com.server.yogiyo.account.entity.enumtypes.OAuthType;
import com.server.yogiyo.account.entity.enumtypes.RoleType;
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

    private Long kakaoId;

    private boolean alarmAgree;

    public static Account createAccount(AccountAuthDto dto) {

        return Account.builder()
                .status(Status.Valid)
                .nickname(dto.getNickname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .grade(GradeType.요기프랜드)
                .oAuth(OAuthType.None)
                .role(RoleType.ROLE_USER)
                .alarmAgree(dto.getAlarmAgree())
                .build();
    }

    public AccountAuthDto getAccountInfoDto() {

        return AccountAuthDto.builder()
                .accountId(this.accountId)
                .email(this.email)
                .nickname(this.nickname)
                .alarmAgree(this.alarmAgree)
                .build();
    }

    public void setKakaoInfoByEmail(Long kakaoId) {
        this.kakaoId = kakaoId;
        this.oAuth = OAuthType.Kakao;
    }

}
