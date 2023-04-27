package com.example.mvc.spring_jdbc;

import com.example.mvc.jdbc.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PersonSpringRepository {

    // 스프링 JDBC 활용 - 데이터베이스 접속 설정 정보를
    // 설정 파일을 통해 불러와서 사용합니다.

    private final JdbcTemplate jdbcTemplate;


    // 저장 기능
    public void savePerson(Person p){

        String sql = "INSERT INTO PERSON (PERSON_NAME, PERSON_AGE) VALUES(?, ?)";
        jdbcTemplate.update(sql,p.getPersonName(), p.getPersonAge());

    }

    // 삭제 기능
    public void removePerson(long id){

        String sql = "DELETE FROM PERSON WHERE ID = ?";
        jdbcTemplate.update(sql, id);

    }


    // 수정 기능
    public boolean modify(Person p){

        String sql = "UPDATE PERSON SET PERSON_NAME = ?, PERSON_AGE =?  WHERE ID = ?";

        int result = jdbcTemplate.update(sql, p.getPersonName(), p.getPersonAge(), p.getId());
        return result == 1;

    }

    // 전체 조회 기능

    public List<Person> findAll(){

        String sql = "SELECT * FROM PERSON";
        return jdbcTemplate.query(sql,(rs, rowNum) -> new Person(rs));

    }

    public Person findOne(long id){

        String sql = "SELECT * FROM PERSON WHERE ID = ?";
        return  jdbcTemplate.queryForObject(sql, (rs, n)-> new Person(rs)
        , id);

    }











}
