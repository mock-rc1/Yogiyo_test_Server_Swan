package com.server.yogiyo.account.oauth.kakao;

import com.server.yogiyo.account.AccountController;
import com.server.yogiyo.account.AccountRepository;
import com.server.yogiyo.account.AccountService;
import com.server.yogiyo.account.dto.AccountAuthDto;
import com.server.yogiyo.account.dto.SignInReq;
import com.server.yogiyo.account.dto.SignInRes;
import com.server.yogiyo.account.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.server.yogiyo.configure.entity.Status.*;


@Transactional
@RequiredArgsConstructor
@Service
public class KakaoOAuthService {

    private final KakaoOAuth2 kakaoOAuth2;
    private final AccountService accountService;
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${OAuth.KAKAO_TOKEN}")
    private String KAKAO_TOKEN;

    public SignInRes kakaoLogin(String code){
        KakaoUserInfo kakaoUserInfo = kakaoOAuth2.getUserInfo(code);
        Long kakaoId = kakaoUserInfo.getId();
        String nickname = kakaoUserInfo.getNickname();
        String email = kakaoUserInfo.getEmail();

        Account account = null;
        Optional<Account> byKakaoIdAndStatus = accountRepository.findByKakaoIdAndStatus(kakaoId, Valid);
        if (byKakaoIdAndStatus.isPresent()) account = byKakaoIdAndStatus.get();
        else {
            Optional<Account> emailAccount = accountRepository.findByEmailAndStatus(email, Valid);
            if (emailAccount.isPresent()){
                emailAccount.get().setKakaoInfoByEmail(kakaoId);
                account = emailAccount.get();
            }
            else{
                AccountAuthDto accountReq = AccountAuthDto.builder()
                        .email(email)
                        .nickname(kakaoId + "_" + nickname)
                        .password(passwordEncoder.encode(kakaoId + KAKAO_TOKEN))
                        .alarmAgree(false)
                        .build();

                Account newAccount = Account.createAccount(accountReq);
                Account save = accountRepository.save(newAccount);
                account = save;
            }
        }

        SignInReq signInreq = SignInReq.builder()
                .email(account.getEmail())
                .password(kakaoId + KAKAO_TOKEN)
                .build();


        return accountService.signIn(signInreq);

    }
}
