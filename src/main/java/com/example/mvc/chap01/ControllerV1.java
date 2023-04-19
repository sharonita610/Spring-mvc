package com.example.mvc.chap01;

// 어떤 요청들을 처리할지 공통 URL을 설계

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/spring/*")

// 이 클래스으 객체를 스프링이 관리하도록 빈을 등록
@Controller //@Component와 같은 개념
public class ControllerV1 {

    // 세부 요청들은 메서드를 통해 처리
    @RequestMapping("/hello") // http://localhost:8181/spring/hello -> 이런 경로다
    public String hello() {
        System.out.println("\n====== 헬로 요청이 들어옴!! ======\n");
        return "hello"; // 어떤 jsp를 열어줄지에 대한 경로를 적는다

    }

    // /spring/food 요청이 오면 food.jsp를 열어보세요

    @RequestMapping("/food")
    public String food() {
        System.out.println("\n===== food 요청이 들어옴1!! ====\n");
        return "chap01/food";
    }

    // ============ 요청 파라미터 읽기 (Query String parameter) =============/
    // == 1. HttpServletRequest 사용하기
    // ==> ex) /spring/person?name=kim&age=30
    @RequestMapping("/person")
    public String person(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        return "";
    }

    // == 2. @RequestParam 사용하기
    // ex) /spring/major?stu=kim&major=business&grade=3

    @RequestMapping("/major")
    public String major(
            String stu,
            @RequestParam("major") String mj,
            @RequestParam(defaultValue = "1") int grade
    ){
        String major = "전공전고오옹";

        System.out.println("stu = " + stu);
        System.out.println("major = " + mj);
        System.out.println("grade = " + grade);
        return     "";

    }

    // == 3. 커맨드 이용하기
    // == 쿼리 스트링 양이 너무 많을 경우 또는 연관성이 있을 경우
    // ==> ex) /spring/order?oNum=20230419007-P&goods=구두&amount=3&price=50000...

    @RequestMapping("/order")
    public String order(OrderRequestDTO dto){

        System.out.println("dto = " + dto);
        
        return "";
    }

    // == 4. URL에 경로로 붙어있는 데이터 읽기
    // ==> /spring/member/hong/107
    //      hong 이라는 유저의 107번 게시글을 읽고싶음

    @RequestMapping("/member/{userName}/{bNo}")
    public String member(
            @PathVariable String userName,
            @PathVariable long bNo

    ){
        System.out.println("userName = " + userName);
        System.out.println("bNo = " + bNo);



        return "";
    }


//    @RequestMapping("/food-select")
    // 음식 선택 요청 처리
    @PostMapping( "/food-select")
    public String foodSelect(
            String foodName,
            String category
    ){

        System.out.println("foodName = " + foodName);
        System.out.println("category = " + category);


        return "hello";
    }


}
