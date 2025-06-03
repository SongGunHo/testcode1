package com.koreait.spring4.glbal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcAuditing;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 설정 파일 에노테이션
@EnableJdbcAuditing// 엔티를 지원 하는 에노 테이션
public class MvcConfig implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { // 정적 리스소를 처리 하는 메서드
        registry.addResourceHandler("/**").addResourceLocations("/classpath/static");


    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter (){
        return new HiddenHttpMethodFilter();
    }


}
