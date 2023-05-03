package com.example.mvc.practicing.dto;

import lombok.*;

// RequestDTO 는 동물 등록을 위한 DTO, 필요한 정보만 정제한것



@Setter @Getter @ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class AnimalRequestDTO {

    private String aniName;
    private int aniAge;
    private char aniGender;
    private String aniGuardian;
    private String aniAddr;
    private String aniType;

}
