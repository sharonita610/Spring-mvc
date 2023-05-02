package com.example.mvc.practicing.entity;


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
    private String aniMom;
    private String aniAddr;


}
