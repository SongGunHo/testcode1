package com.koreait.spring4.glbal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanConfig {


    @Lazy // 지연 초기한 하는 에노 테이션
    @Bean// 수동 등록 하는 빈
    public ModelMapper modelMapper(){

    }











}
