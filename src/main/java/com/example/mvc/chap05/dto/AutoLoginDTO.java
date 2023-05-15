package com.example.mvc.chap05.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class AutoLoginDTO {

    private String sessionId;
    private LocalDateTime limitTime;
    private String account;

}
