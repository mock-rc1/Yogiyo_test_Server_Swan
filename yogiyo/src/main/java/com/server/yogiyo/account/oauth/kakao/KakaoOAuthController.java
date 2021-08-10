package com.server.yogiyo.account.oauth.kakao;

import com.server.yogiyo.account.dto.SignInRes;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/app")
public class KakaoOAuthController {

    private final KakaoOAuthService kakaoOAuthService;
    private final ResponseService responseService;

    @GetMapping("/account/kakao/callback")
    public DataResponse<SignInRes> kakaoLogin(String code) {
        SignInRes signInRes = kakaoOAuthService.kakaoLogin(code);
        return responseService.getDataResponse(signInRes);
    }

}
