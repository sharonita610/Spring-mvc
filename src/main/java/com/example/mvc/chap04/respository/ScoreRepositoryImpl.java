package com.example.mvc.chap04.respository;

import com.example.mvc.chap04.dto.ScoreRequestDTO;
import com.example.mvc.chap04.entity.Score;
import org.springframework.stereotype.Repository;

import java.util.*;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

//@Component // 스프링 빈 등록 : 객체의 생성의 제어권을 스프링에게 위임
@Repository
public class ScoreRepositoryImpl implements ScoreRepository {

    // key : 학번, value: 성적정보
    public static final Map<Integer, Score> scoreMap;
    private static int sequence;

    static {
        scoreMap = new HashMap<>();
        Score stu1 = new Score(new ScoreRequestDTO("뽀로로", 100, 50, 70));
        Score stu2 = new Score(new ScoreRequestDTO("춘식이", 33, 56, 12));
        Score stu3 = new Score(new ScoreRequestDTO("뽀로로", 76, 80, 72));

        stu1.setStuNum(++sequence);
        stu2.setStuNum(++sequence);
        stu3.setStuNum(++sequence);

        scoreMap.put(stu1.getStuNum(), stu1);
        scoreMap.put(stu2.getStuNum(), stu2);
        scoreMap.put(stu3.getStuNum(), stu3);
    }


    @Override
    public List<Score> findAll() {
        return new ArrayList<>(scoreMap.values())
                .stream()
                .sorted(comparing(Score::getStuNum))
                .collect(toList());

    }

    @Override
    public List<Score> findAll(String sort) {
        Comparator<Score> comparator = comparing(Score::getStuNum);
        switch (sort) {
            case "num":
                comparator =comparing(Score::getStuNum);
                break;
            case "name":
                comparator =comparing(Score::getName);
                break;
            case "avg":
                comparator =comparing(Score::getAverage);
                break;
        }
        return new ArrayList<>(scoreMap.values())
                .stream()
                .sorted(comparator)
                .collect(toList());

    }

    @Override
    public boolean save(Score score) {
        if (scoreMap.containsKey(score.getStuNum())) {
            return false;
        }
        score.setStuNum(++sequence);
        scoreMap.put(score.getStuNum(), score);
        System.out.println(findAll());
        return true;
    }


    @Override
    public boolean deleteByStuNum(int stuNum) {
        if (!scoreMap.containsKey(stuNum)) return false;
        scoreMap.remove(stuNum);
        return true;
    }


    @Override
    public Score findByStuNum(int stuNum) {

        return scoreMap.get(stuNum);
    }

//    @Override
//    public boolean update(int stuNum, ScoreRequestDTO dto){
//        // Score 객체 꺼내기
//        Score score = scoreMap.get(stuNum);
//
//        // 점수 재설정
//
//        score.changeScore(dto);
//        return true;
//    }


}
