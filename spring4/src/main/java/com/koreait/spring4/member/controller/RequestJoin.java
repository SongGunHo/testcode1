package com.koreait.spring4.member.controller;

import lombok.Data;

@Data
public class RequestJoin {

    private String email;
    private String password;
    private String name;
    private String mobile;


}
