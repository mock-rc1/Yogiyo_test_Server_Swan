package com.server.yogiyo.configure.response.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomExceptionStatus {


    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    EMPTY_JWT(false, 2001, "JWT를 입력해주세요."),
    INVALID_JWT(false, 2002, "유효하지 않은 JWT입니다."),
    INVALID_USER_JWT(false,2003,"권한이 없는 유저의 접근입니다."),
    NOT_AUTHENTICATED_ACCOUNT(false, 2004, "로그인이 필요합니다."),

    // users
    USERS_EMPTY_USER_ID(false, 2010, "유저 아이디 값을 확인해주세요."),
    ACCOUNT_NOT_FOUND(false, 2011, "사용자를 찾을 수 없습니다."),

    // Restaurants
    Restaurant_NOT_FOUND(false, 2012, "가게를 찾을 수 없습니다."),

    // Menus
    MENU_NOT_FOUND(false, 2013, "메뉴를 찾을 수 없습니다."),

    // Options
    OPTIONS_NOT_FOUND(false, 2013, "주문 옵션을 찾을 수 없습니다."),

    // Orders
    EXIST_ANOTHER_Restaurant(false, 2014, "다른 가게에서 주문 중 입니다."),

    // [POST] /users
    POST_USERS_EMPTY_EMAIL(false, 2015, "이메일을 입력해주세요."),
    POST_USERS_INVALID_EMAIL(false, 2016, "이메일 형식을 확인해주세요."),
    POST_USERS_EXISTS_EMAIL(false,2017,"중복된 이메일입니다."),
    POST_USERS_INVALID_NICKNAME(false, 2018, "닉네임 형식을 확인해주세요."),
    POST_USERS_INVALID_PASSWORD(false, 2021, "비밀번호 형식을 확인해주세요."),
    POST_USERS_EMPTY_PASSWORD(false, 2022, "비밀번호를 입력해주세요"),
    POST_USERS_EMPTY_AGREE(false, 2023, "알람 동의 여부를 확인해주세요."),



    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),

    // [POST] /users
    DUPLICATED_EMAIL(false, 3013, "중복된 이메일입니다."),
    DUPLICATED_NICKNAME(false, 3014, "중복된 닉네임입니다."),
    DUPLICATED_NICKNAME_SELF(false, 3015, "원래의 닉네임과 중복됩니다."),
    FAILED_TO_LOGIN(false,3016,"없는 이메일이거나 비밀번호가 틀렸습니다."),



    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다."),

    //[PATCH] /users/{userIdx}
    MODIFY_FAIL_USERNAME(false,4014,"유저네임 수정 실패"),

    PASSWORD_ENCRYPTION_ERROR(false, 4011, "비밀번호 암호화에 실패하였습니다."),
    PASSWORD_DECRYPTION_ERROR(false, 4012, "비밀번호 복호화에 실패하였습니다.");


    // 5000

    // 6000


    private final boolean isSuccess;
    private final int code;
    private final String message;

}
