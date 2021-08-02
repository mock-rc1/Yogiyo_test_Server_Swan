package com.server.yogiyo.util;

import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;

public class ValidationExceptionProvider {

    public static CustomExceptionStatus getExceptionStatus(String code, String target) {
        if (code.equals("NotBlank")){
            if (target.equals("email")) return CustomExceptionStatus.POST_USERS_EMPTY_EMAIL;
            else if (target.equals("password")) return CustomExceptionStatus.POST_USERS_EMPTY_PASSWORD;
        }
        else if (code.equals("Pattern") || code.equals("Length")){
            if (target.equals("nickname")) return CustomExceptionStatus.POST_USERS_INVALID_NICKNAME;
            else if (target.equals("password")) return CustomExceptionStatus.POST_USERS_INVALID_PASSWORD;
        }
        else if (code.equals("Email")) {
            return CustomExceptionStatus.POST_USERS_INVALID_EMAIL;
        }
        return null;
    }

}
