package com.example.mvc.etc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j // 로그 라이브러리
public class LogService {


    /*
        - 로그 : 발생 시간, 로그 레벨, 파일 저장
        - 로그 라이브러리 : logback, log4j, slf4j

        - 로그 레벨
        1. trace : 에플리케이션의 실행흐름 세부 정보, 디버깅 목적
        2. debug : 변수값, 파라이터값 내부 정보 출력, 디버깅 목적

        ==== 운영 서버 ====
        3. info : 운영 환경에서 일반적인 정보들, 시스템 상태, 진행중인 작업 정보
        ==== 개발 서버  ====

        4. warn : 잠재적인 문제 상황을 경고, 구성값이 예상 범위를 벗어났거나 시스템 리소스 부족
        5. error : 예외가 발생하거나 기능이 실패했을 때 심각한 문제 상황
        6. fatal : 치명적인 오류 시스템이 지속될 수 없는 상황, 즉각 조치가 필요한 경우
     */

    public void showLog(){

        System.out.println("hello Log!");


        log.trace("hello trace!");
        log.debug("hello debug");
        log.info("hello info");
        log.warn("hello warn");
        log.error("hello error");



    }




}



