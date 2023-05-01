package com.example.mvc.chap05.entity;

import com.example.mvc.chap05.dto.BoardWriteRequestDTO;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    private int boardNo; // 게시글 번호
    private String title; // 제목
    private String content; // 내용
    private int viewCount; // 조회수
    private LocalDateTime regDateTime; // 작성일자시간

/*
CREATE TABLE TBL_BOARD(
    BOARD_NO INT(10) AUTO_INCREMENT PRIMARY KEY ,
    TITLE VARCHAR(80) NOT NULL,
    -- 2기가 까지 쓸 수 있음 CLOB
    CONTENT VARCHAR(2000),
    VIEW_COUNT INT (10) DEFAULT 0,
    REG_DATE_TIME DATETIME DEFAULT CURRENT_TIMESTAMP
                      -- 시간 자동 주입. INSERT 시에
);

 */


    public Board(int boardNo, String title, String content) {
        this.boardNo = boardNo;
        this.title = title;
        this.content = content;
        this.regDateTime = LocalDateTime.now();
    }

    public Board(BoardWriteRequestDTO dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.regDateTime = LocalDateTime.now();
    }
}