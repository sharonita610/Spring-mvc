package com.example.mvc.chap01;


import lombok.*;

// DTO(Data Transfer Object)
// 클라인언트의 요청 데이터를 서버에서 받을 때
// 서버의 응답 데이터를 클라이언트로 보낼 때 사용하는 객체
@Setter @Getter @ToString @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequestDTO {

    // 필드명이 클라이언트가 보낸 쿼리 스트링 이름과 같아야함
    // setter 이랑 기본 생성자가 있어야 동작함
    private String oNum; // 주문번호
    private String goods; // 상품명
    private int amount; // 수량
    private int price; // 상품가격

}
