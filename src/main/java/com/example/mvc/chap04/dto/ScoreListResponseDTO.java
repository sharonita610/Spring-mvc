package com.example.mvc.chap04.dto;

import com.example.mvc.chap04.entity.Grade;
import com.example.mvc.chap04.entity.Score;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor // final 만 골라서 초기화
@Getter @ToString @EqualsAndHashCode
public class ScoreListResponseDTO {

    private final int stuNum;
    private final String maskingName; // 첫 글자 빼고 별처리
    private final double average;
    private final Grade grade;


    public ScoreListResponseDTO(Score s) {
        this.stuNum = s.getStuNum();
        this.maskingName = makeMaskingname(s.getName());
        this.average = s.getAverage();
        this.grade = s.getGrade();
    }

    // 첫글자만 빼고 다 *처리
    private String makeMaskingname(String name) {
        String maskingName  = String.valueOf(name.charAt(0));
        for (int i = 1; i < name.length(); i++) {
            maskingName += "*";
        }
        return maskingName;
    }
}
