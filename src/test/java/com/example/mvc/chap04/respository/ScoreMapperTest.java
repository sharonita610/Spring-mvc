package com.example.mvc.chap04.respository;

import com.example.mvc.chap04.entity.Score;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ScoreMapperTest {

    @Autowired
    ScoreMapper mapper;

    @Test
    @DisplayName("점수를 하나씩넣자")
    void saveTest(){

        Score score = Score.builder()
                            .name("홓홓홓")
                            .kor(70)
                            .eng(80)
                            .math(90)
                            .build();

        boolean flag = mapper.save(score);

        assertTrue(flag);

    }
    @Test
    @DisplayName("아이디로 지워주자")
    void deleteByIdTest(){
        // given
        int stuNum = 8;

        // when
        boolean flag = mapper.deleteByStuNum(stuNum);

        // then
        assertTrue(flag);

    }

    @Test
    @DisplayName("전체 조회를 해보쟈")
    void findAll(){
        // given
//        List<Score> list = mapper.findAll();
//        list.forEach(System.out::println);

        // when

        // then
//        assertEquals(3,list.size());

    }

    @Test
    @DisplayName("한명씩 조회해보쟈")
    void findByStuNum(){
        // given
        int id = 11;

        // when
        Score s = mapper.findByStuNum(id);
        System.out.println("s = " + s);
        assertEquals("홓홓홓", s.getName());
        assertNotNull(s);



    }

}