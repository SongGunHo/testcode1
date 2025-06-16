package com.koreait.spring4.member.controller;

import lombok.Data;

import java.util.List;

@Data
public class RequestLogin {

    private String email;
    private String password;
    private boolean autoLogin; //자동 로그인
    private String redirectUrl;//
    private List<String> fieldError; // 필드명 에러
    private List<String> globalError;






}
