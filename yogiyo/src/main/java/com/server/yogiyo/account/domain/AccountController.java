package com.server.yogiyo.account.domain;

import com.server.yogiyo.account.domain.dto.SignUpDto;
import com.server.yogiyo.configure.response.CommonResponse;
import com.server.yogiyo.configure.response.DataResponse;
import lombok.RequiredArgsConstructor;
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
        if (errors.hasErrors()) System.out.println(errors.getAllErrors());
        return accountService.signUp(dto);
    }

}
