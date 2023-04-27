package com.example.mvc.chap04.service;

// 컨트롤러와 레파지토리 사이 비즈니스 로직 처리
// ex ) 트랜잭션 처리, 예외처리, dto 변환처리

import com.example.mvc.chap04.dto.ScoreListResponseDTO;
import com.example.mvc.chap04.dto.ScoreRequestDTO;
import com.example.mvc.chap04.entity.Score;
import com.example.mvc.chap04.respository.ScoreMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

//@RequiredArgsConstructor // 생성자가 하나일때 이렇게 사용 가능하다.
@Service
public class ScoreService {

    private final ScoreMapper scoreRepository;

    public ScoreService(ScoreMapper scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

//    @Autowired
//    public ScoreService(@Qualifier("jdbc") ScoreRepository scoreRepository) {
//        this.scoreRepository = scoreRepository;
//    }

    // 목록조회 중간처리
    /*
        컨트롤러는 데이터베이스를 통해
        성적 정보 리스트를 가져오길 원한다.
        그런데, 데이터베이스는 성적 정보를 전부 모아서 준다
        컨트롤러는 일부만 받았으면 좋겠다.
     */
    public List<ScoreListResponseDTO> getList(String sort){

        // scoreList에서 원하는 정보만 추출하고 이름은 마스킹해서
        // 다시 DTO 리스트로 변환해줘야 한다.

        return scoreRepository.findAll()
                .stream()
                .map(ScoreListResponseDTO::new)
                .collect(toList());

    }


    // 등록 중간 처리
    // Controller은 나에게 DTO를 줬지만
    // reposistory 는 ScoreEntity를 달라고 한다
    // 내가 변환해야겠네..
    public boolean insertScore(ScoreRequestDTO dto){

        return  scoreRepository.save(new Score(dto));

    }

    // 삭제 중간 처리
    public boolean delete(int stuNum){

        return  scoreRepository.deleteByStuNum(stuNum);
    }

    // 상세 조회, 수정화면 조회 중간처리
    public Score retrieve(int stuNum){


        return scoreRepository.findByStuNum(stuNum);
    }


}
