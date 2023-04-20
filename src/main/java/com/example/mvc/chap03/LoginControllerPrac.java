package com.example.mvc.chap03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sh")
public class LoginControllerPrac {

     /*
            1번요청: 로그인 폼 화면 열어주기
            - 요청 URL : /hw/s-login-form : GET
            - 포워딩 jsp파일 경로:  /WEB-INF/views/chap03/s-form.jsp --> 열려야됨, return
            - html form: 아이디랑 비번을 입력받으세요.

            2번요청: 로그인 검증하기
            - 로그인 검증: 아이디를 grape111이라고 쓰고 비번을 ggg9999 라고 쓰면 성공
            - 요청 URL : /hw/s-login-check : POST
            - 포워딩 jsp파일 경로:  /WEB-INF/views/chap03/s-result.jsp
            - jsp에게 전달할 데이터: 로그인 성공여부, 아이디 없는경우, 비번 틀린경우

         */

    @GetMapping("/login-form")
    public String loginPrac(){
        System.out.println("로그인 페이지로 이동 성공!");
        return "chap03/login-prac";
    }

    @PostMapping("/login-checking")
    public String loginChecking(String id, String pwd, Model model) {
        String result = "";


        if (id.equals("aaaa")) {
            if (pwd.equals("1111")) {
                result = "로그인되었습니다!";

            } else {
                result = "비밀번호가 틀렸습니다";
            }
        } else {
            result = "아ㅇ이디가 잘못 되었습니다";
        }

        model.addAttribute("result", result);
        return "chap03/login-checking";

    }




}
