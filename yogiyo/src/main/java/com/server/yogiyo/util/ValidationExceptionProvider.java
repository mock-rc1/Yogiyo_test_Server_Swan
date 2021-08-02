package com.server.yogiyo.util;

import com.server.yogiyo.configure.response.exception.CustomExceptionStatus;

public class ValidationExceptionProvider {

    public static CustomExceptionStatus getExceptionStatus(String target) {
        if (target.equals("email")) return CustomExceptionStatus.POST_USERS_INVALID_EMAIL;
        else if (target.equals("nickname")) return CustomExceptionStatus.POST_USERS_INVALID_NICKNAME;
        else if (target.equals("password")) return CustomExceptionStatus.POST_USERS_INVALID_PASSWORD;
        return null;
    }

}
