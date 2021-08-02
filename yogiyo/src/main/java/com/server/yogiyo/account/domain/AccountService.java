package com.server.yogiyo.account.domain;

import com.server.yogiyo.account.domain.dto.SignInReq;
import com.server.yogiyo.account.domain.dto.SignInRes;
import com.server.yogiyo.account.domain.dto.AccountInfoDto;
import com.server.yogiyo.configure.response.DataResponse;
import com.server.yogiyo.configure.response.ResponseService;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.jwt.JwtTokenProvider;
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
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public DataResponse<AccountInfoDto> signUp(AccountInfoDto dto) {
        if (accountRepository.findByEmail(dto.getEmail()).isPresent()) throw new CustomException(CustomExceptionStatus.DUPLICATED_EMAIL);
        if (dto.getNickname() != null){
            if (accountRepository.findByNickname(dto.getNickname()).isPresent()) throw new CustomException(CustomExceptionStatus.DUPLICATED_NICKNAME);
        }

        dto.changePassword(passwordEncoder.encode(dto.getPassword()));
        Account account = Account.createAccount(dto);
        Account save = accountRepository.save(account);
        dto.setAccountId(save.getAccountId());
        return responseService.getDataResponse(dto);
    }

    @Transactional
    public DataResponse<SignInRes> signIn(SignInReq req) {
        Optional<Account> optionalAccount = accountRepository.findByEmail(req.getEmail());
        if (!optionalAccount.isPresent()) throw new CustomException(CustomExceptionStatus.FAILED_TO_LOGIN);
        Account accountEntity = optionalAccount.get();
        if(!passwordEncoder.matches(req.getPassword(),accountEntity.getPassword())){
            throw new CustomException(CustomExceptionStatus.FAILED_TO_LOGIN);
        }

        SignInRes res = SignInRes.builder()
                .accountId(accountEntity.getAccountId())
                .jwt(jwtTokenProvider.createToken(accountEntity.getEmail(), accountEntity.getRole()))
                .build();

        return responseService.getDataResponse(res);
    }

    public DataResponse<AccountInfoDto> getAuthAccount(String email) {
        Optional<Account> optionalAccount = accountRepository.findByEmail(email);
        if (!optionalAccount.isPresent()) throw new CustomException(CustomExceptionStatus.ACCOUNT_NOT_FOUND);
        return responseService.getDataResponse(optionalAccount.get().getAccountInfoDto());
    }
}
