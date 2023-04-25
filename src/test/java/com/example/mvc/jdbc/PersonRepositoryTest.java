package com.example.mvc.jdbc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    PersonRepository repository;

    // save
    @Test
    @DisplayName("사람의 이름과 나이 정보를 DB person 에 잘 삽입해야한다.")
    void saveTest(){
        // given

        Person p = new Person();
        p.setPersonName("천지호");
        p.setPersonAge(5);


        // when
        repository.save(p);

        // then
    }


    @Test
    @DisplayName("사람의 이름과 나이 정보를 " +
            "DB person table에 잘 수정해야 한다.")
    void updateTest(){
        // given

        Person p = new Person();
        p.setPersonName("수정이주정이");
        p.setPersonAge(99);
        p.setId(4L);

        // when
        repository.update(p);



        // when


        // then
    }
    // remove
    @Test
    @DisplayName("사람의 이름과 나이 정보를 DB person 에 잘 삭제해야한다.")
    void removeTest(){
        // given

        long id = 1L;



        // when
        repository.remove(id);

        // then
    }

    // 전체 조회하기
    @Test
    void findAllTest(){
        List<Person> people = repository.findAll();
        for (Person p : people) {
            System.out.println("p = " + p);
        }
    }

    // 한명만 조회하기
    @Test
    void findOneTest(){
        Person p = repository.findOne(10L);
        System.out.println("p = " + p);

    }





}