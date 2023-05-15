package com.example.mvc.interceptor;

// 인터셉터 : 하위 컨트롤러에 요청이 들어가기 전, 후에 
//          공통으로 검사할 일들을 정의해놓는 클래스
// 게시판 관련 인가 처리

import com.example.mvc.chap05.entity.Board;
import com.example.mvc.chap05.repository.BoardMapper;
import com.example.mvc.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.example.mvc.util.LoginUtil.isAdmin;

@Configuration
@Slf4j
@RequiredArgsConstructor

public class BoardInterceptor implements HandlerInterceptor {

    public final BoardMapper boardMapper;

    // 인터셉터로 사용하려면 꼭 implements HandlerInterceptor 이게 필요하다.


    @Override
    public boolean preHandle(HttpServletRequest request, 
                             HttpServletResponse response, 
                             Object handler) throws Exception {
        
        // 로그인을 했는지 확인할 것임.
        // 로그인 안했으면 로그인 페이지로 강제로 redirect 할것임

        HttpSession session = request.getSession();

        if(!LoginUtil.isLogin(request.getSession())){

            log.info("this request ( {} ) denied!!", request.getRequestURI());
            response.sendRedirect("/members/sign-in");
            return false;

        }
        // 삭제 요청을 한다면 자기가 쓴 글 또는 관리자인지 체크
        /*
            1. 우선 로그인 계정과 삭제하려는 게시물의 계정명이 일치해야함
            2. 로그인 계정은 세션에서 구할 수 있음
            3. 삭제 하려는 게시물의 계정은 어케 구함?
             -> 삭제 요청에는 글번호 정보가 있다
             -> 글번호를 db에 조회해서 계정명을 얻어낸다
        */
        // 삭제요청인지 확인
        String uri = request.getRequestURI();
        if(uri.contains("delete")){

            // 쿼리 파라미터 읽기
            int bno = Integer.parseInt(request.getParameter("bno" ));

            // 게시물 정보 읽기

            Board board = boardMapper.findOne(bno);
            String targetAccount = board.getAccount();

            if(isAdmin(session)) return true;

            if ( !LoginUtil.isMine(session, targetAccount)) {
                response.sendRedirect("/access-deny");
                return false;
            }
        }


        
        log.info("board interceptor pass!!");
        return true;
    }
}
