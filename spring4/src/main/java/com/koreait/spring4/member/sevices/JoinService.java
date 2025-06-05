package com.koreait.spring4.member.sevices;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Lazy
@RequiredArgsConstructor
public class JoinService {

    private final MemberMapprer memberMapprer;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository repository;

    public void process(){
        String hash = form.getMobile();
        if(StringUtils.hasText(moblie)){
            moblie
        }
    }



}
