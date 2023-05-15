package com.example.mvc.interceptor;

import com.example.mvc.chap05.entity.Member;
import com.example.mvc.chap05.repository.MemberMapper;
import com.example.mvc.chap05.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDateTime;

import static com.example.mvc.util.LoginUtil.AUTO_LOGIN_COOKIE;
@Configuration
@RequiredArgsConstructor
public class AutoLoginInterceptor implements HandlerInterceptor {

    private final MemberMapper memberMapper;
    private final MemberService memberService;

    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler){

        //1. 자동로그인 쿠키를 탐색
        Cookie[] cookies = request.getCookies();
        // 우리 대신 util이 반복문을 돌려준다
        Cookie c = WebUtils.getCookie(request, AUTO_LOGIN_COOKIE);

        if(c != null){
            // 2. 쿠키에 저장된 세션 아이디를 읽는다.
            String sessionId = c.getValue();

            // 3. DB에서 세션 아이디로 회원 정보를 조회한다.
            Member foundMember = memberMapper.findMemberByCookie(sessionId);

            // 4. 회원이 조회가 되었고 자동로그인 만료일 이전이라면
            if (foundMember != null && LocalDateTime.now().isBefore(foundMember.getLimitTime())) {

                // 5. 로그인 처리
                memberService.maintainLoginState(request.getSession(), foundMember.getAccount());

            }

        }
        return true;
    }



}
