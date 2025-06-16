package com.koreait.spring4.glbal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.time.Duration;

@Configuration
public class I18NCcnfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor);
    }

    @Bean
    public localeChangeInterceptor localeChangeInetrceptor(){
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");

        return interceptor;
    }

    @Bean
    public CookieLocaleResolver localeResolver(){
        CookieLocaleResolver cool = new CookieLocaleResolver();
        cool.setCookieMaxAge(Duration.ofHours(1L));


        return cool;
    }









}
