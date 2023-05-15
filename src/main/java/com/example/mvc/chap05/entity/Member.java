package com.example.mvc.chap05.entity;
import lombok.*;
import java.time.LocalDateTime;

/*
CREATE  TABLE TBL_MEMBER (

        ACCOUNT VARCHAR(50),
        PASSWORD VARCHAR(150) NOT NULL ,
        NAME VARCHAR(50) NOT NULL ,
        EMAIL VARCHAR(100) NOT NULL UNIQUE ,
        AUTH VARCHAR(20) DEFAULT 'COMMON',
        REG_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
        CONSTRAINT PK_MEMBER PRIMARY KEY (ACCOUNT)


        );
*/


@Setter @Getter
@ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private String account;
    private String name;
    private String password;
    private String email;
    private Auth auth;
    private LocalDateTime regDate;
    private LocalDateTime limitTime;


}
