package com.koreait.spring4.member.libs;

import com.koreait.spring4.member.constants.Authortiy;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Member;

import static org.apache.coyote.http11.Constants.a;

@Lazy
@Component
public class MemberUtils {


    //로그인 여부
    public boolean isLogin(){
        return getMember() != null;
    }

    // 관리자 여부
    public boolean isAdmin() {
        return  isLogin() && getMember().getAuthority() == Authortiy.ADMIN;

    }

    // 로그인 회원 정보
    public Member getMember(){
        Authentication c = SecurityContextHolder.getContext().getAuthentication();
        if (c !=null && c.getPrincipal() instanceof  MemberInfo memberInfo){
            return memberInfo.getMember();
        }
        return null;

    }

}
