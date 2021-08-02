package com.server.yogiyo.configure.response;
;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommonResponse {

    protected boolean isSuccess;

    protected int code;

    protected String message;

}