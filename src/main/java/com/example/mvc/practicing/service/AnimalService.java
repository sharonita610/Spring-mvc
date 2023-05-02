package com.example.mvc.practicing.service;

import com.example.mvc.practicing.dto.AnimalListDTO;
import com.example.mvc.practicing.entity.Animal;
import com.example.mvc.practicing.repository.AnimalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// 서비스는 db에 바로 연결되어있다.
// db는 워낙 많은 정보를 가지고 있기 때문에 클라쪽에 보여줄 내용들만 걸러서
// controller 쪽으로 전달해주면 된다.
// controller은 말 그대로 컨트롤 타워를 한다. url mapping을 그쪽에서 처리해주면 된다.


// @Service를 붙여서 빈 등록을 해준다.
@Service
public class AnimalService {

    // @RequiredArgsConstructor 이걸 사용해서 밑에 mapper 생성자를
    // 생성해서 @Autowired 를 시킨다
    private final AnimalMapper animalRepository;

    @Autowired
    private AnimalService(AnimalMapper animalRepository){

        this.animalRepository = animalRepository;
    }

    // 중간처리 기능은 자유롭게 사용 할 수 있다.

    public boolean delete(int aniNum){
        return animalRepository.deleteByNum(aniNum);
    }

    public Animal retrieve(int aniNum){
        return animalRepository.findOne(aniNum);
    }

//    public boolean insertAnimal(Animal)

    public List<AnimalListDTO> getList(String list){

        return animalRepository.findAll(list)
                .stream()
                .map(AnimalListDTO::new)
                .collect(Collectors.toList());
    }





}
