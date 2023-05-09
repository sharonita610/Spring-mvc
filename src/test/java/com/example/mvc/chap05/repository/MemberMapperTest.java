package com.example.mvc.chap05.repository;

import com.example.mvc.chap05.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class MemberMapperTest {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    PasswordEncoder encoder;


    @Test
    @DisplayName("회원가입에 성공해야한다")
    void registerTest() {

        Member member = Member.builder()
                .account("lion")
                .password(encoder.encode("aaa1234"))
                .name("라이언씨")
                .email("lion@naver.com")
                .build();
        Boolean flag = memberMapper.save(member);

        assertTrue(flag);


    }

    @Test
    @DisplayName("peach 라는 계정명으로 회원을 조회하면 그 회원의 이름이 복숭아씨 여야한다")
    void findMemberTest() {

        // given
        String acc = "peach";

        // when
        Member foundMember = memberMapper.findMember(acc);

        // then
        System.out.println("foundMember = " + foundMember);
        assertEquals("복숭아씨", foundMember.getName());

    }

    @Test
    @DisplayName("계정명이 peach 인 경우 결과 값이 1이 나와야한다")
    void accountDuplicateTest() {

        // given
        String acc = "peach";

        // when
        int count = memberMapper.isDuplicate("account", acc);

        // then
        assertEquals(1, count);

    }

    @Test
    @DisplayName("이메일이 peach@naver.com 인 경우 결과 값이 1이 나와야한다")
    void emailDuplicateTest() {

        // given
        String email ="peach@naver.com";

        // when
        int count1 = memberMapper.isDuplicate("email", email);

        // then
        assertEquals(1, count1);

    }

    @Test
    @DisplayName("비밀번호가 암호화 되어야한다")
    void encodingTest(){

        // 인코딩 전 패스워드
        String rawPassword = "abc1234!";

        // 인코등 후 패스워드
        String encodedPassword = encoder.encode(rawPassword);

        System.out.println("rawPassword = " + rawPassword);
        System.out.println("encodedPassword = " + encodedPassword);

    }

}