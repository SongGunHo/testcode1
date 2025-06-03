package com.koreait.spring4.glbal.advice;

import com.koreait.spring4.glbal.libs.Utils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@ControllerAdvice // 전역 적으로 예외 발생 하는 애노테이션
public class CommonControllerAdvice {

    private final Utils utils;



    @ExceptionHandler(Exception.class) // 특정 예외  처리 하는 메서드 를 정의 할때 사용 하는 애노 테이션
    public ModelAndView errorHandler(Exception e , HttpServletRequest request){
        Map<String ,String> data = new HashMap<>();


        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500
        String message = e.getMessage();
        String tpl = "error/common";


        if(e instanceof CommonException commonException){
            status = commonException.getStatus();
            if(commonException.isErrorCode){ // 메세지 코드로 메세지를 가져 와야 하는 경우
                message = utils.getMassage(message);
            }


            // 자바 스크립트 alart 형태로 출력 하는 예외
            if(e instanceof AlartException){
                tpl = "common/_excute_script";
                String callback = "";
                // history.back(추가
                if (e instanceof AlertRedirectExcetion redirectExcetion){
                    callback = String.format("()=>%s.localtion.replace('%s')", redirectExcetion.getTarget(), redirectExcetion.getPath, redirectExcetion.getUrl());
                }

                String script = String.format("alart('%s,%s')", message, callback);
                data.put("script", script);
            }
        }
        data.put("status", status.toString());
        data.put("message", message);
        data.put("path", request.getRequestURI());
        data.put("method", request.getMethod());

        ModelAndView mv = new ModelAndView();
        mv.setStatus(status);
        mv.addAllObjects(data);
        mv.setViewName(tpl);

        return mv;



    }









































































}
