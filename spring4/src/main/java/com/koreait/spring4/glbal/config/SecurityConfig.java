package com.koreait.spring4.glbal.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor //lombok 에노테이션
public class SecurityConfig {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.formLogin(c->{
            c.loginPage("/member/login")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .successHandler()
                    .failureHandler()
        });

        http.logout(c->{
            c.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/member/logout");
        });


        // 자동 로그인 설정 "
        http.rememberMe(c->{
            c.rememberMeParameter("autoLogin")
                    .tokenValiditySeconds(60* 60.*24*7)
                    .userDetailsService(new )
                    .authenticationSuccessHandler(new );
        });
        /* 인가 설정 - 자원에 대한 접근 권한 설정 S */
        /**
         * authenticated() : 인증받은 사용자만 접근 가능(회원)
         * anonymous() : 인증받지 않은 사용자만 접근 가능(비회원)
         * permitAll() : 모든 사용자가 접근 가능
         * hasAuthority("권한이름") : 하나의 권한을 체크
         * hasAnyAuthority("권한1", "권한2", ...) : 다수의 권한을 체크
         * hasRole("롤 이름") : ROLE_롤이름, 롤 이름으로 권한을 체크
         * hasAnyRole("롤1", "롤2", ...) : 다수의 롤으로 권한을 체크
         * anyRequest().permitAll() : 비회원 페이지가 기본, 일부 페이지 - 회원전용
         * anyRequest().authenticated() : 회원 전용페이지가 기본, 일부 페이지 - 비회원
         *
         *
         */
        http.authorizeHttpRequests(c->{
            c.requestMatchers("/mypage/**").authenticated() // 회원 전용
                    .requestMatchers("/member/join").anonymous() // 비회원 전용
                    .anyRequest().permitAll();// 비회원 페이지가 기본 회원 전용 ;





        });

        http.exceptionHandling(c->{
            c.authenticationEntryPoint(new );
            c.accessDeniedHandler(new );
        });
        return http.build();
    }

    @Bean // 수동 빈
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



























}
