package com.koreait.spring4.glbal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {


    @Bean
    public MessageSourceConfig messageSourceConfig(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.addBasenames("message.commons", "message.validations" , "message.errors");
        ms.setDefaultEncoding("UTF-8");
        ms.setUseCodeAsDefaultMessage(true);

        return  ms;
    }







}
