package com.example.mvc.practicing.repository;

import com.example.mvc.practicing.entity.Animal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class AnimalMapperTest {

    // repository 연결을 위해 autowired를 어노트 해준다
    @Autowired
    AnimalMapper mapper;

    @Test
    @DisplayName("동물등록을 한다")
    void saveTest() {
        // given

        Animal a = Animal.builder()
                .aniName("빼로")
                .aniAge(6)
                .aniGender('F')
                .aniMom("길자")
                .aniAddr("관악구")
                .build();

        boolean flag = mapper.save(a);

        assertTrue(flag);



    }

    @Test
    @DisplayName("등록된 동물 한마리를 삭제한다")
    void deleteTest(){
        int aniNum = 2;

        Boolean flag = mapper.deleteByNum(aniNum);

        assertTrue(flag);
    }

    @Test
    @DisplayName("동물 등록번호 4번의 주인은 Elias이고 관악구에 거주한다 동물번호로 정보를 조회한다")
    void findOneTest(){
        int aniNum = 4;
        String name = "Elias";

        Animal one = mapper.findOne(aniNum);

        assertEquals(name, one.getAniMom());
        assertEquals("관악구", one.getAniAddr());


    }

}