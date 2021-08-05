package com.server.yogiyo.account;

import com.server.yogiyo.account.entity.Account;
import com.server.yogiyo.account.dto.SignInReq;
import com.server.yogiyo.account.dto.SignInRes;
import com.server.yogiyo.account.dto.AccountAuthDto;
import com.server.yogiyo.configure.entity.Status;
import com.server.yogiyo.configure.response.exception.CustomException;
import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;
import com.server.yogiyo.configure.security.authentication.CustomUserDetails;
import com.server.yogiyo.configure.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.server.yogiyo.configure.entity.Status.*;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public AccountAuthDto signUp(AccountAuthDto dto) {
        if (accountRepository.findByEmailAndStatus(dto.getEmail(), Valid).isPresent()) throw new CustomException(CustomExceptionStatus.DUPLICATED_EMAIL);
        if (dto.getNickname() != null){
            if (accountRepository.findByNicknameAndStatus(dto.getNickname(), Valid).isPresent()) throw new CustomException(CustomExceptionStatus.DUPLICATED_NICKNAME);
        }

        dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        Account account = Account.createAccount(dto);
        Account save = accountRepository.save(account);
        dto.setAccountId(save.getAccountId());
        dto.setJwt(jwtTokenProvider.createToken(account.getEmail(),account.getRole()));
        return dto;
    }

    @Transactional
    public SignInRes signIn(SignInReq req) {
        Optional<Account> optionalAccount = accountRepository.findByEmailAndStatus(req.getEmail(), Valid);
        if (!optionalAccount.isPresent()) throw new CustomException(CustomExceptionStatus.FAILED_TO_LOGIN);
        Account accountEntity = optionalAccount.get();
        if(!passwordEncoder.matches(req.getPassword(),accountEntity.getPassword())){
            throw new CustomException(CustomExceptionStatus.FAILED_TO_LOGIN);
        }

        SignInRes res = SignInRes.builder()
                .accountId(accountEntity.getAccountId())
                .jwt(jwtTokenProvider.createToken(accountEntity.getEmail(), accountEntity.getRole()))
                .build();

        return res;
    }

    public AccountAuthDto getAuthAccount(CustomUserDetails customUserDetails) {
        Account account = customUserDetails.getAccount();
        AccountAuthDto accountInfoDto = account.getAccountInfoDto();
        accountInfoDto.setJwt(jwtTokenProvider.createToken(account.getEmail(), account.getRole()));
        return accountInfoDto;
    }
}
