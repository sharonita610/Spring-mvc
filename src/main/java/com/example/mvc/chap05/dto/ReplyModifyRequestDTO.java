package com.example.mvc.chap05.dto;

import com.example.mvc.chap05.entity.Reply;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter @Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ReplyModifyRequestDTO extends ReplyPostRequestDTO {

    @NotNull
    @Min(0) @Max(Long.MAX_VALUE) // 반드시 정수 입력하도록 체크
    private Long boardNo;

    @NotNull
    @Min(0) @Max(Long.MAX_VALUE)
    private Long replyNo;

    @NotBlank
    private String text;


    public Reply ToEntity(){
        return Reply.builder()
                .replyNo(this.replyNo)
                .boardNo(this.boardNo)
                .replyText(this.text)
                .build();
    }

}
