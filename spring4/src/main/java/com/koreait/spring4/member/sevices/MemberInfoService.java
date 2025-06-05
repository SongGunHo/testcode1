package com.koreait.spring4.member.sevices;

import com.koreait.spring4.member.constants.Authortiy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;

@Service
public class MemberInfoService implements UserDetailsService {

    private final MemberRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = repository.findBuEmail(email).orElseThrow(()-> new UsernameNotFoundException(username));

        Authortiy a = Object.requireNoNullElse(member.getAuthority(), Authortiy.MEMBER);

        List<SimpleGrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(a.name())); // list.of 리스트르 변경이 불가 한다


        return Memberinfo.builder().email(member.getEmail()).passowrd(member.getPassword()).member(member).authorities(authorities).build();

    }
}
