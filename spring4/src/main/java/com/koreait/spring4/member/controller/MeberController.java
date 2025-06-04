package com.koreait.spring4.member.controller;

import com.koreait.spring4.glbal.libs.Utils;
import com.koreait.spring4.member.libs.MemberUtils;
import com.koreait.spring4.member.sevices.JoinService;
import com.koreait.spring4.member.validators.JoinValidator;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MeberController {


    private final Utils utils;
    private final JoinValidator joinValidator;
    private final JoinService joinService;  // 회원 가입 관련 서비스
    private final MemberUtils memberUtils;

    @ModelAttribute("/addCss")
    public List<String> addCss(){
        return List.of("member/style");
    }

    @ModelAttribute("requestLogin")
    public RequestLogin login(){
        return new RequestLogin();
    }

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form , Model model){
            commonProcess("join", model);

            return utils.tpl("member/join");
    }

    @PostMapping("/join")
    public String joinPS(@Valid RequestJoin form , Errors errors , Model model){
        commonProcess("join", model);

        joinValidator.validate(form, errors);

        if(error.hasErrors){
            return utils.tpl("/member/join");
        }

        joinService.process(form);

        // 회원 가입 서공
        return "redircet:/member/login";
    }

    @GetMapping("/login")
    public String login (@ModelAttribute RequestLogin form , Errors errors , Model model){
        commonProcess("login", errors);

        List<String> findErrors = form.getFieldError();
        if(findErrors != null){
            findErrors.forEach(s->{
                String[] value = s.split("_");// 문자열을 큭정 구분자를 기준으로 나누어 리스트로 반환
                errors.rejectValue(value[0], value[1]);

            });

            List<String> globalErrors = form.getGlobalError();
            if()


        }

    }




































}
