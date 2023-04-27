package com.example.mvc.chap04.respository;

import com.example.mvc.chap04.entity.Score;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreMapper {

    // 전체 목록 조회
    List<Score> findAll();

    // 성적 정보 등록
    boolean save(Score score);

    // 성적정보 한개 삭제
    boolean deleteByStuNum(int stuNum);

    // 성적정보 개별 조회
    Score findByStuNum (int stuNum);



}
