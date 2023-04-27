package com.example.mvc.spring_jdbc;

import com.example.mvc.jdbc.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PersonSpringRepositoryTest {

    @Autowired
    PersonSpringRepository repository;

    @Test
    void savePersonTest(){

        // given
        Person p = new Person();
        p.setPersonName("김스프");
        p.setPersonAge(2);

        // when
        repository.savePerson(p);


    }
    @Test
    void removePersonTest(){

        // given
        long id = 11L;

        // when
        repository.removePerson(id);

    }

    @Test
    void modify(){


        // given
        Person p = new Person();
        p.setId(6L);
        p.setPersonName("뿡뿡이");
        p.setPersonAge(33);
        // when

        boolean flag = repository.modify(p);

        // then
        assertTrue (flag);
    }

    @Test
    void findAllTest(){
        List<Person> people = repository.findAll();
        for (Person p : people) {
            System.out.println("p = " + p);
        }
    }

    @Test
    void findOneTest(){
        Person p = repository.findOne(7L);
        System.out.println("p = " + p);
        assertEquals("대길이", p.getPersonName());

    }



}