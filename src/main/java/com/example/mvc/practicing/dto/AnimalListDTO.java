package com.example.mvc.practicing.dto;

import com.example.mvc.practicing.entity.Animal;
import lombok.*;

@RequiredArgsConstructor // final 만 골라서 초기화
@Getter @ToString @EqualsAndHashCode
@Setter
public class AnimalListDTO {

    // 클라이언트에게 게시글 목록을 줄 때 스펙


    private final int aniNum;
    private final String aniName;
    private final int aniAge;
    private final char aniGender;
    private final String aniGuardian;
    private final String aniAddr;
    private final String aniType;

    public AnimalListDTO(Animal ani) {
        this.aniNum = ani.getAniNum();
        this.aniName = ani.getAniName();
        this.aniAge = ani.getAniAge();
        this.aniGender = ani.getAniGender();
        this.aniGuardian = ani.getAniGuardian();
        this.aniAddr = ani.getAniAddr();
        this.aniType = ani.getAniType();
    }
}
