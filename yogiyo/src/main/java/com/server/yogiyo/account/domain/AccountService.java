package com.server.yogiyo.account.domain;

import com.server.yogiyo.account.domain.dto.SignUpDto;
import com.server.yogiyo.configure.response.CommonResponse;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final ResponseService responseService;

    @Transactional
    public DataResponse<SignUpDto> signUp(SignUpDto dto) {
        Optional<Account> optionalAccount = accountRepository.findByEmail(dto.getEmail());
        if (optionalAccount.isPresent()) throw new CustomException(CustomExceptionStatus.DUPLICATED_EMAIL);
        dto.changePassword(passwordEncoder.encode(dto.getPassword()));
        Account account = Account.createAccount(dto);
        Account save = accountRepository.save(account);
        dto.setAccountId(save.getAccountId());
        return responseService.getDataResponse(dto);
    }
}
