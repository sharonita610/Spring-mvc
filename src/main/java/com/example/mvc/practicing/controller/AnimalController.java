package com.example.mvc.practicing.controller;

import com.example.mvc.practicing.dto.AnimalListDTO;
import com.example.mvc.practicing.dto.AnimalRequestDTO;
import com.example.mvc.practicing.entity.Animal;
import com.example.mvc.practicing.service.AnimalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


// 디스패처 서블릿에게 이 객체를 주입시키기 위해 @Controller을 만들어야됨.
@Controller
@RequiredArgsConstructor // : final field만 초기화 하는 생성자
@RequestMapping("/animal") // url 기본 맵핑
@Slf4j
public class AnimalController {

/*
    # 요청 URL
    1. animal 등록화면을 보여주고, animal 목록조회 처리
    - /animal/list : GET

    2. 동물 정보 등록 처리 요청
    - /animal/register : POST

    3. 동물 정보 삭제 요청
    - /animal/remove : POST

    4. 동물 정보 조회 요청
    - /animal/detail : GET

 */


    private final AnimalService animalService;

    // 1. 동물등록화면 보이게 하기 + 목록 조회

    @GetMapping("/list")
    public String list(Model model){
        log.info("/animal/list : GET!");
        List<AnimalListDTO> list1 = animalService.getList();

        model.addAttribute("aList",list1);

        return "practicing/list";
    }

    @PostMapping("/register")
    public String registerAnimal(AnimalRequestDTO dto){

        log.info("/animal/register : POST!");

        animalService.insertAnimal(dto);


        return "redirect:/animal/list";
    }

    @GetMapping("/delete")
    public String deleteAnimal(int aniNum){

        log.info("/animal/delete : POST!");

        animalService.delete(aniNum);

        return "redirect:/animal/list";
    }

    @GetMapping("/detail")
    public String animalDetail(int aniNum, Model model){

        log.info("/animal/detail : GET!!");
        Animal list =  animalService.retrieve(aniNum);

        model.addAttribute("a", list);

        return "practicing/detail";
    }

    @GetMapping("/newRegister")
    public String newRegister(){
        log.info("/animal/newRegister : GET!!");

        return "practicing/register";
    }



}
