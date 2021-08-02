package com.server.yogiyo.account.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import static com.fasterxml.jackson.annotation.JsonProperty.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SignUpDto {

    private Long accountId;

    @Email
    @NotBlank
    private String email;

    @Length(min=3, max = 20)
    @Pattern(regexp = "^[ㄱ-ㅎ가-힣a-zA-Z0-9_-]{3,20}$")
    private String nickname;

    @NotBlank
    @JsonProperty(access = Access.WRITE_ONLY)
    @Length(min=8, max= 50)
    private String password;

    private boolean alarmAgree;

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }
}
