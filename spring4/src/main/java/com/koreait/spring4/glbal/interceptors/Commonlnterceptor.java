package com.koreait.spring4.glbal.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component // 빈을 자동으로 등록 해주는 애노테이션
@RequiredArgsConstructor // find 이나 notnull 자동으로 생성 해준다
public class Commonlnterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView !=null){
            modelAndView.addAllObjects("isLogin", memberUtils.isLogin);
        }
    }
}
