package com.example.mvc.practicing.repository;

import com.example.mvc.practicing.entity.Animal;
import org.apache.ibatis.annotations.Mapper;

// 우선 repository 에는 Mapper 하나만 사용한다.
// 그리고 Mapper 로 사용하려면 @Mapper을 달아준다.
@Mapper
public interface AnimalMapper {

    // 등록된 동물들의 리스트를 볼 수 있다.

    // 동물등록을 할 수 있다.
    Boolean save(Animal animal);

    // 등록된 동물의 정보를 조회할 수 있다.
    Animal findOne(int aniNum);

    // 등록된 동물을 삭제할 수 있다.
    Boolean deleteByNum(int aniNum);

    // 조회 화면에서 정보를 수정 할 수 있다.
    // 수정은 조금 더 생각해보는것으로 하자






}
