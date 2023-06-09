package com.example.mvc.chap04.controller;

import com.example.mvc.chap04.dto.ScoreListResponseDTO;
import com.example.mvc.chap04.dto.ScoreRequestDTO;
import com.example.mvc.chap04.entity.Score;
import com.example.mvc.chap04.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/*
    # 요청 URL
    1. 학생 성적 정보 등록화면을 보여주고, 성적정보 목록조회 처리
    - /score/list : GET

    2. 성적 정보 등록 처리 요청
    - /score/register : POST

    3. 성적정보 삭제 요청
    - /score/remove : POST

    4. 성적정보 상세 조회 요청
    - /score/detail : GET

 */
@Controller
@RequestMapping("/score")
//@AllArgsConstructor  모든 필드를 초기화 하는 생성자
@RequiredArgsConstructor // : final field만 초기화 하는 생성자
public class ScoreController {

    //    private final ScoreRepository repository;
    private final ScoreService scoreService;


    // 1.  성적등록화면 띄우기 + 정보 목록 조회
    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(defaultValue = "num") String sort) {

        System.out.println("/score/list : GET!!");
        System.out.println("정렬 요구 사항 : " + sort);


        List<ScoreListResponseDTO> responseDTOList = scoreService.getList(sort);

        model.addAttribute("sList", responseDTOList);

        return "chap04/score-list";
    }

    // 2. 성적 종보 등록 처리요청
    @PostMapping("/register")
    public String register(ScoreRequestDTO dto) {

        // 입력 데이터(쿼리 스트링) 읽기
        System.out.println(" /score/register : POST" + dto);

        scoreService.insertScore(dto);

        /*
            등록 요청에서 jsp 뷰 포워딩을 하면
            갱신된 목록을 다시 한 번 저장소에서 불러와
            모델에 담는 추가적인 코드가 필요하지만

            리다이렉트를 통해서 위에서 만든 /score/list : GET
            을 자동으로 다시 보낼 수 있다면 번거로운 코드가
            줄어 들 수 있겠다.

         */
        return "redirect:/score/list";
    }

    // 3. 성적 정보 삭제
    @GetMapping("remove")
    public String remove(int stuNum) {

        System.out.println("/score/remove : GET");

        scoreService.delete(stuNum);

        return "redirect:/score/list";
    }

    // 4.
    @GetMapping("/detail")
    public String detail(int stuNum,
                         Model model) {
        System.out.println("/score/detail : GET");

        retrive(stuNum, model);


        return "chap04/score-detail";
    }


    // 5. /detail 에서 수정하기를 누르면 get
    @GetMapping("/edit")

    public String edit(int stuNum, Model model) {
        System.out.println("/score/edit : GET");

        retrive(stuNum, model);

        return "chap04/score-edit";
    }

    @PostMapping("/modify")
    public String modify(int stuNum, ScoreRequestDTO dto, Model model) {

        System.out.println("/score/modify : POST");

        Score score = scoreService.retrieve(stuNum);

        score.changeScore(dto);
        return "redirect:/score/detail?stuNum=" + stuNum;
    }

    private void retrive(int stuNum, Model model) {
        Score foundStudent = scoreService.retrieve(stuNum);
        model.addAttribute("s", foundStudent);
    }
}
