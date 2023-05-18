package com.example.mvc.chap05.api;

import com.example.mvc.chap05.dto.ReplyListResponseDTO;
import com.example.mvc.chap05.dto.ReplyModifyRequestDTO;
import com.example.mvc.chap05.dto.ReplyPostRequestDTO;
import com.example.mvc.chap05.dto.page.Page;
import com.example.mvc.chap05.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/replies")
@Slf4j
// 클라이언트의 접근을 어떤 app에서만 허용할 것인가
@CrossOrigin(origins = {"http://localhost:63342","http://localhost:5500" })

public class ReplyController {

    private final ReplyService replyService;

    // 댓글 목록 조회 요청
    // URL : /api/v1/replies/3/page/1
    //         3번 게시물 댓글목록 1페이지 주세여
    @GetMapping("/{boardNo}/page/{pageNo}")
    public ResponseEntity<?> list(
            // 슬래시로 받을때 @PathVariable을 붙여줘야함
            @PathVariable long boardNo,
            @PathVariable int pageNo

    ) {
        log.info("/api/v1/replies/{}/page/{} : GET!", boardNo, pageNo);

        Page page = new Page();
        page.setPageNo(pageNo);
        page.setAmount(10); // 한 페이지에 10개씩

        ReplyListResponseDTO replyList = replyService.getList(boardNo, page);


        return ok().body(replyList);
    }

    // 댓글 등록 요청
    @PostMapping
    public ResponseEntity<?> create(
            // 요청 메시지 바디에 JSON으로 보내주세요
            // @Validated 을 적으면 dto 에서 걸어둔 @NotBlank 조건을 다 확인해준다
            @Validated @RequestBody ReplyPostRequestDTO dto
            , BindingResult result // 검증 결과를 가진 객체

    ) {

        // 입력값 검증에 걸리면 4xx 상태코드 리턴
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.toString());
        }

        log.info("/api/v1/replies : POST!");
        log.info("param : {}", dto);

        // 서비스에 비즈니스 로직 처리 위임
        try {
            ReplyListResponseDTO responseDTO = replyService.register(dto);

            // 성공시 클라이언트 응답하기
            return ResponseEntity.ok().body(responseDTO);

        } catch (Exception e) {

            // 문제발생 상황을 클라이언트에게 전달
            log.warn("500 Status code response!! caused by : {}", e.getMessage());
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }

    }

    // 댓글 삭제 요청
    @DeleteMapping("/{replyNo}")
    public ResponseEntity<?> remove(

            @PathVariable(required = false) Long replyNo

    ) {
        if (replyNo == null) {
            return ResponseEntity.badRequest().body("댓글 번호를 보내주세요!");
        }


        log.info("/api/v1/replies/{} : DELETE!", replyNo);

        try {

            ReplyListResponseDTO responseDTO = replyService.delete(replyNo);
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body(e.getMessage());
        }
    }

    // 댓글 수정 요청

    @PutMapping
    public ResponseEntity<?> modify(
            @Validated @RequestBody ReplyModifyRequestDTO dto
            , BindingResult result
    ) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.toString());
        }

        log.info("/api/v1/replies : PUT!!");
        try {

            ReplyListResponseDTO listResponseDTO = replyService.modify(dto);
            return ResponseEntity.ok().body(listResponseDTO);

        } catch (Exception e) {

            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }


    }


}
