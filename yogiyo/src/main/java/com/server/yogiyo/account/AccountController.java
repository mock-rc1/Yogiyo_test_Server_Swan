package com.server.yogiyo.account;

import com.server.yogiyo.account.dto.SignInReq;
import com.server.yogiyo.account.dto.SignInRes;
import com.server.yogiyo.account.dto.AccountAuthDto;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.util.ValidationExceptionProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/app")
public class AccountController {

    private final AccountService accountService;
    private final ResponseService responseService;

    @PostMapping(value = "/sign-up")
    public DataResponse<AccountAuthDto> signUp(@RequestBody @Valid AccountAuthDto dto, Errors errors){
        if (errors.hasErrors()) ValidationExceptionProvider.throwValidError(errors);
        if (dto.getAlarmAgree() == null || !dto.getAlarmAgree()) throw new CustomException(CustomExceptionStatus.POST_USERS_EMPTY_AGREE);
        return responseService.getDataResponse(accountService.signUp(dto));
    }

    @PostMapping(value = "/sign-in")
    public DataResponse<SignInRes> signIn(@RequestBody @Valid SignInReq req, Errors errors) {
        if (errors.hasErrors()) ValidationExceptionProvider.throwValidError(errors);
        return responseService.getDataResponse(accountService.signIn(req));
    }

    @GetMapping(value = "/accounts/auth")
    public DataResponse<AccountAuthDto> getAuthAccount(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return responseService.getDataResponse(accountService.getAuthAccount(customUserDetails));
    }

}
