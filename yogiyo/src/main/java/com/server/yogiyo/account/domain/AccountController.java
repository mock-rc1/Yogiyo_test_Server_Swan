package com.server.yogiyo.account.domain;

import com.server.yogiyo.account.domain.dto.SignInReq;
import com.server.yogiyo.account.domain.dto.SignInRes;
import com.server.yogiyo.account.domain.dto.AccountInfoDto;
import com.server.yogiyo.configure.response.DataResponse;
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

    @PostMapping(value = "/sign-up")
    public DataResponse<AccountInfoDto> signUp(@RequestBody @Valid AccountInfoDto dto, Errors errors){
        if (errors.hasErrors()) throwValidError(errors);
        if (dto.getAlarmAgree() == null) throw new CustomException(CustomExceptionStatus.POST_USERS_EMPTY_AGREE);
        return accountService.signUp(dto);
    }

    @PostMapping(value = "/sign-in")
    public DataResponse<SignInRes> signIn(@RequestBody @Valid SignInReq req, Errors errors) {
        if (errors.hasErrors()) return throwValidError(errors);
        return accountService.signIn(req);
    }

    @GetMapping(value = "/accounts/auth")
    public DataResponse<AccountInfoDto> getAuthAccount(@AuthenticationPrincipal CustomUserDetails customUserDetails) {
        return accountService.getAuthAccount(customUserDetails.getUsername());
    }

    private DataResponse<SignInRes> throwValidError(Errors errors) {
        String errorCode = errors.getFieldError().getCode();
        String errorTarget = errors.getFieldError().getField();
        throw new CustomException(ValidationExceptionProvider.getExceptionStatus(errorCode, errorTarget));
    }

}
