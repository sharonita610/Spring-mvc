package com.example.mvc.practicing.service;

import com.example.mvc.practicing.repository.AnimalMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

// @Service를 붙여서 빈 등록을 해준다.
@Service
@RequiredArgsConstructor
public class AnimalService {

    // @RequiredArgsConstructor 이걸 사용해서 밑에 mapper 생성자를
    // 생성해서 @Autowired 를 시킨다
    private final AnimalMapper animalMapper;

    // 중간처리 기능은 자유롭게 사용 할 수 있다.









}
