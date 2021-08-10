package com.server.yogiyo.account.oauth.kakao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class KakaoUserInfo {

    Long id;
    String email;
    String nickname;

}
