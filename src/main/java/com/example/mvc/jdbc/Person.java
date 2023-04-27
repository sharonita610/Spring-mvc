package com.example.mvc.jdbc;


import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

// entity : ? ???? ?????? ????? ??? ?? ??
// DB table? ??? 1:1 ? ???? ??? ?????
@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Person {

    private long id;
    private String personName;
    private int personAge;


    public Person(ResultSet rs) throws SQLException {

        this.id = rs.getLong("id");
        this.personName = rs.getString("person_name");
        this.personAge = rs.getInt("person_age");


    }
}
