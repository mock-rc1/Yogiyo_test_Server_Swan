package com.server.yogiyo.account.authentication;

import com.server.yogiyo.configure.response.CommonResponse;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/app")
public class SmsAuthController {

    private final SmsAuthService smsAuthService;
    private final ResponseService responseService;

    @PatchMapping(value = "/accounts/sms-token")
    public DataResponse<Integer> updateAccountSmsToken(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                                       @RequestBody PhoneNumberDto phoneNumberDto) {
        Integer token = smsAuthService.updateAccountSmsToken(customUserDetails, phoneNumberDto.getPhoneNumber());
        return responseService.getDataResponse(token);
    }

    @PatchMapping(value = "/accounts/sms-certification")
    public CommonResponse updateAccountSmsCertification(@AuthenticationPrincipal CustomUserDetails customUserDetails,
                                                @RequestBody TokenDto tokenDto) {
        smsAuthService.updateAccountSmsCertification(customUserDetails, tokenDto.getSmsToken());
        return responseService.getSuccessResponse();
    }
}
