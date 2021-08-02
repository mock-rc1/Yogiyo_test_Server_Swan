package com.server.yogiyo.account.domain;

import com.server.yogiyo.account.domain.dto.SignInReq;
import com.server.yogiyo.account.domain.dto.SignInRes;
import com.server.yogiyo.account.domain.dto.SignUpDto;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.exception.CustomException;
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
    public DataResponse<SignUpDto> signUp(@RequestBody @Valid SignUpDto dto, Errors errors){
        if (errors.hasErrors()) {
            String errorTarget = errors.getFieldError().getField();
            throw new CustomException(ValidationExceptionProvider.getExceptionStatus(errorTarget));
        }
        return accountService.signUp(dto);
    }

    @PostMapping(value = "/sign-in")
    public DataResponse<SignInRes> signIn(@RequestBody @Valid SignInReq req, Errors errors) {
        if (errors.hasErrors()) {
            String errorTarget = errors.getFieldError().getField();
            throw new CustomException(ValidationExceptionProvider.getExceptionStatus(errorTarget));
        }
        return accountService.signIn(req);
    }
    
}
