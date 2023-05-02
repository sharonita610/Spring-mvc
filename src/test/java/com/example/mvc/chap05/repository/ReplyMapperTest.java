package com.example.mvc.chap05.repository;

import com.example.mvc.chap05.dto.page.Page;
import com.example.mvc.chap05.entity.Board;
import com.example.mvc.chap05.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    BoardMapper boardMapper;

    @Autowired
    ReplyMapper replyMapper;

    @Test
    @DisplayName("게시물 300개를 등록하고 각 개시물에 랜덤으로 1000개의 댓글을 나눠서 등록해야한다.")
    void bulkInsertTest() {

//        for (int i = 0; i <= 300; i++) {
//            Board b = Board.builder()
//                    .title("재미있는 게시물 " + i)
//                    .content("노잼 게시물 내용 " + i)
//                    .build();
//            boardMapper.save(b);
//        }
//
//        assertEquals(301, boardMapper.count(new Search()));

        for (int i = 0; i <= 1000; i++) {
            Reply r = Reply.builder()
                    .replyWriter("잼민이 " + i)
                    .replyText("말똥이~~ " + i)
                    .boardNo((long) (Math.random() * 300 + 1))
                    .build();
            replyMapper.save(r);
        }

    }

    @Test
    @DisplayName("댓글 3번 게시물에 등록하면 3번 게시물의 총 댓글 수는 3개여야 한다")
    //테스트 할때 세이브가 되지 않게 롤백처리를 해주는 코드. @Transactional @Rollback
    @Transactional
    @Rollback
    void saveTest() {
        // given
        long boardNo = 3L;

        Reply newReply = Reply.builder()
                .replyText("세이브세이브")
                .replyWriter("긴또깡")
                .boardNo(boardNo)
                .build();

        // when

        boolean flag = replyMapper.save(newReply);


        // then
        assertTrue(flag);
        assertEquals(5, replyMapper.count(boardNo));
    }

    @Test
    @DisplayName("댓글 번호가1004번인 댓글을 삭제하면 3번 게시물의 총 댓글수가 3이어야한다 ")
    @Transactional
    @Rollback
    void deleteTest() {


        long replyNo = 1004L;
        long boardNo = 3L;

        boolean flag = replyMapper.deleteOne(replyNo);

        assertTrue(flag);
        assertEquals(3, replyMapper.count(boardNo));

    }

    @Test
    @DisplayName("1번 게시물에는 ")
    void findAllTest() {

        long boardNo = 1L;

        List<Board> all = replyMapper.findAll(boardNo, new Page());


        assertEquals(4, all.size());
    }

    @Test
    @DisplayName("1번 게시물에서 495번 댓글을 단 사람은 잼민이 494번 일것이다.")
    void findOneTest() {

        // given
        long replyNo = 495L;
        long boardNo = 1L;

        // when

        Reply one = replyMapper.findOne(boardNo);


        // then


    }

    @Test
    @DisplayName("1번 게시물 495번 작성 내용을 를 바꾼다")
//    @Transactional @Rollback
    void modifyTest() {
        // given
        long replyNo = 495L;

        String newText = "홍홍홍";
        // when
        Reply r = Reply.builder()
                .replyText(newText)
                .replyNo(replyNo)
                .build();
        // then

        boolean flag = replyMapper.modify(r);

        assertTrue(flag);
        assertEquals(newText, replyMapper.findOne(replyNo).getReplyText());
    }


}