package com.example.mvc.chap05.entity;

/*
    CREATE TABLE TBL_REPLY(
    REPLY_NO INT(10) AUTO_INCREMENT,
    REPLY_TEXT VARCHAR(1000) NOT NULL ,
    REPLY_WRITER VARCHAR(100) NOT NULL ,
    REPLY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP,
    BOARD_NO INT(10),

    CONSTRAINT PK_REPLY PRIMARY KEY (REPLY_NO),
    CONSTRAINT FK_REPLY FOREIGN KEY (BOARD_NO)
                      REFERENCES TBL_BOARD (BOARD_NO)
                      ON DELETE CASCADE
    # ON DELETE CASCADE 원글이 지워지면 댓글도 삭제하겠다.

);
 */


import lombok.*;

import java.time.LocalDateTime;

@Setter @Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reply {

    private long replyNo;
    private String replyText;
    private String replyWriter;
    private LocalDateTime replyDate;
    private long boardNo;
    private String account;

    private String profileImage;



}
