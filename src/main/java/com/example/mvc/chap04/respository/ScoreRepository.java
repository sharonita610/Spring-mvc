package com.example.mvc.chap04.respository;

// 역할 명세 (추상화) :
// 성적 정보를 잘 저장하고 추가하고 조회하고 삭제하고 수정해야 한다
// 그래서 어디에 저장하는건데?
// 어디에서 조회하니? 어디에서 삭제하니?

import com.example.mvc.chap04.dto.ScoreRequestDTO;
import com.example.mvc.chap04.entity.Score;

import java.util.List;

import static com.example.mvc.chap04.respository.ScoreRepositoryImpl.scoreMap;

public interface ScoreRepository {



    // 성적 정보 전체 목록 조회
    List<Score> findAll(); // 일반 목록 조회
    default List<Score> findAll(String sort){ // interface에 default를 주면 강제오버라이딩이 되지 않는다.
        return null;
    } // 정렬 목록 조회

    // 성적 정보 등록
    boolean save(Score score);

    // 성적 정보 삭제
    boolean deleteByStuNum(int stuNum);

    // 성적 정보 개별 조회
    Score findByStuNum(int stuNum);



}
