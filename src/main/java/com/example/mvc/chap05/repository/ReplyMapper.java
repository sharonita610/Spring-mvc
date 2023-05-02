package com.example.mvc.chap05.repository;

import com.example.mvc.chap05.dto.page.Page;
import com.example.mvc.chap05.entity.Board;
import com.example.mvc.chap05.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    // 댓글 등록
    boolean save(Reply reply);


    // 댓글 수정
    boolean modify(Reply reply);


    // 댓글 삭제
    boolean deleteOne(long replyNo);


    // 댓글 개별 조회
    Reply findOne(long replyNo);


    // 댓글 목록 조회
    List<Board> findAll(
            @Param("bn") long boardNo,
            @Param("p") Page page);

    // 위에처럼 테이블안에 겹치는 매게변수 타이틀? 이름이 있으면 @Param으로 닉네임처럼 처리해주면 된다.

    // 댓글 수 조회
    int count(long boardNo);


}
