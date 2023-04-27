package com.example.mvc.chap04.entity;

import com.example.mvc.chap04.dto.ScoreRequestDTO;
import lombok.*;

import java.sql.ResultSet;
import java.sql.SQLException;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Score {


    private String name;
    private int kor, eng, math;
    private int stuNum;
    private int total;
    private double average;
    private Grade grade;


    public Score(ScoreRequestDTO dto) {

        this.name = dto.getName();
        this.kor = dto.getKor();
        this.eng = dto.getEng();
        this.math = dto.getMath();
        calcTotalAvg(); // 총점, 평균 계산
        calcGrade(); // 학점 계산


    }

    public Score(ResultSet rs) throws SQLException {

        this.stuNum = rs.getInt("stu_num");
        this.name = rs.getString("name");
        this.kor = rs.getInt("kor");
        this.math = rs.getInt("math");
        this.eng = rs.getInt("eng");
        this.total = rs.getInt("total");
        this.average = rs.getDouble("average");
        this.grade = Grade.valueOf(rs.getString("grade"));



    }

    private void calcGrade() {

        if (average >= 90) {
            this.grade = Grade.A;
        } else if (average >= 80) {
            this.grade = Grade.B;
        } else if (average >= 70) {
            this.grade = Grade.C;
        } else if (average >= 60) {
            this.grade = Grade.D;
        } else {
            this.grade = Grade.F;
        }


    }

    private void calcTotalAvg() {
        this.total = kor + eng + math;
        this.average = ((Math.round(total / 3.0)*100)/100);
    }

    public void changeScore(ScoreRequestDTO dto) {

        this.kor = dto.getKor();
        this.eng = dto.getEng();
        this.math = dto.getMath();

        calcTotalAvg();
        calcGrade();
    }
}
