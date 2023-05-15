package com.example.mvc.config;

import com.example.mvc.interceptor.AfterLoginInterceptor;
import com.example.mvc.interceptor.AutoLoginInterceptor;
import com.example.mvc.interceptor.BoardInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 다양한 인터셉터 관련 설정을 등록하는 클래스
@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {

    // 인터셉터 설정 등록
    private final BoardInterceptor boardInterceptor;
    private final AfterLoginInterceptor afterLoginInterceptor;
    private final AutoLoginInterceptor autoLoginInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 게시판 인터셉터 설정
        registry.addInterceptor(boardInterceptor)
                .addPathPatterns("/board/*") // 어떤 경로에서 인터셉터를 실행할 것인가
                .excludePathPatterns("/board/list", "/board/detail"); // 인터셉터를 실행하지 않을 경로
    // 로그인 후처리 인터셉터 설정
    registry.addInterceptor(afterLoginInterceptor)
            .addPathPatterns("/members/sign-in", "/members/sign-up");


    // 자동 로그인 인터셉터 설정
        registry.addInterceptor(autoLoginInterceptor)
                .addPathPatterns("/**");
    }



}
