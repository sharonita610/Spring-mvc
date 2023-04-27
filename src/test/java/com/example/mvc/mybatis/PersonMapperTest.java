package com.example.mvc.mybatis;

import com.example.mvc.jdbc.Person;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonMapperTest {

    @Autowired
    PersonMapper mapper;

    @Test
    @DisplayName("마이바티스 매퍼로 사람 정보 저장에 성공해야한다")
    void saveTest(){

        // given
        Person p = Person.builder()
                .personName("김바랑")
                .personAge(44)
                .build();

        // when
        boolean flag = mapper.save(p);

        // then
        assertTrue(flag);


    }

    @Test
    @DisplayName("마이바티스 매퍼로 사람 정보 수정에 성공해야한다")
    void changeTest(){

        // given
        Person p = Person.builder()
                .personName("마바수정")
                .personAge(88)
                .id(6L)
                .build();

        // when
        boolean flag = mapper.change(p);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("마이바티스 매퍼로 사람 정보 삭제에 성공해야한다")
    void removeTest(){

        // given
        long id = 11L;
        // when
        boolean flag = mapper.remove(id);

        // then
        assertTrue(flag);
    }

    @Test
    @DisplayName("마이바티스 매퍼로 사람 정보 전체 조회에 성공해야한다")
    void findAllTest(){

        // given

        // when
        List<Person> people = mapper.findAll();

        people.forEach(System.out::println);

        // then
        assertEquals(8, people.size());
    }

    @Test
    @DisplayName("마이바티스 매퍼로 사람 정보 개별 조회에 성공해야한다")
    void findOneTest(){

        // given
        long id = 12L;

        // when
        Person p = mapper.findOne(id);

        System.out.println("p = " + p);
        assertEquals("김바랑", p.getPersonName());
        assertEquals(44, p.getPersonAge());
        assertNotNull(p);

        // then
    }




}