package com.example.mvc.chap05.repository;

import com.example.mvc.chap05.dto.AutoLoginDTO;
import com.example.mvc.chap05.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {


    // 회원 가입
    boolean save(Member member);


    // 회원 정보 조회
    Member findMember(String account);



    // 중복 체크기능(account, email)

    // Query 에서 count(*) 로 했을때 중복이 있는지 확인 할 수 있는 방법은
    // 1이면 존재, 0이면 가입 가능
    int isDuplicate(
            @Param("type") String type,
            @Param("keyword")String keyword
    );


    // 자동로그인 관련 속성 추가 기능
    void saveAutoLogin(AutoLoginDTO dto);

    // 쿠키 값(세션 id)으로 회원을 조회하는 기능
    Member findMemberByCookie(String sessionOD);

}
