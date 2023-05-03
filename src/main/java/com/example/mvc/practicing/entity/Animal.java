package com.example.mvc.practicing.entity;


import com.example.mvc.practicing.dto.AnimalRequestDTO;
import lombok.*;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {

    private int aniNum;
    private String aniName;
    private int aniAge;
    private char aniGender;
    private String aniGuardian;
    private String aniAddr;
    private String aniType;


    public Animal(AnimalRequestDTO dto) {

        this.aniName = dto.getAniName();
        this.aniAge = dto.getAniAge();
        this.aniGuardian = dto.getAniGuardian();
        this.aniType = dto.getAniType();
        this.aniGender = dto.getAniGender();
        this.aniAddr = dto.getAniAddr();
    }
}
