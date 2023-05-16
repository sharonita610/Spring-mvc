package com.example.mvc.chap05.dto;

import lombok.*;

@Setter @Getter @ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class LoginUserResponseDTO {

    private String account;
    private String nickName;
    private String email;
    private String auth;
    private String profile;




}
