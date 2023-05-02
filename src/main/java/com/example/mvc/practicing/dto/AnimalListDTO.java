package com.example.mvc.practicing.dto;

import com.example.mvc.practicing.entity.Animal;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor // final 만 골라서 초기화
@Getter @ToString @EqualsAndHashCode

public class AnimalListDTO {

    // 클라이언트에게 게시글 목록을 줄 때 스펙

    private final String aniName;
    private final int aniAge;
    private final char aniGender;
    private final String aniMom;
    private final String aniAddr;

    public AnimalListDTO(Animal ani) {
        this.aniName = ani.getAniName();
        this.aniAge = ani.getAniAge();
        this.aniGender = ani.getAniGender();
        this.aniMom = ani.getAniMom();
        this.aniAddr = ani.getAniAddr();
    }
}
