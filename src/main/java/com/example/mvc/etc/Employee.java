package com.example.mvc.etc;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {


    private int empId; // 사번

    private String empName; // 사원명

    private String position; // 직급

    private LocalDate hireDate; // 입사일자


    // 빌더 패턴 구현

    // 1. 내부 클래스를 외부와 같은 스팩으로 만듬
    public static class MemberBuilder {

        private int empId; // 사번

        private String empName; // 사원명

        private String position; // 직급

        private LocalDate hireDate; // 입사일자

        // 2. 내부 클래스의 생성자를 private 으로 제한해서 클래스 밖에서 생성 불가능하게 함
        private void EmployeeBuilder() {
        }

        // 3. 각 필드별로 빌더 메서드들을 구현

        public MemberBuilder empId(int empId) {
            this.empId = empId;
            return this;
        }

        public MemberBuilder empName(String empName) {
            this.empName = empName;
            return this;
        }

        public MemberBuilder position(String position) {
            this.position = position;
            return this;
        }

        public MemberBuilder hireDate(LocalDate hireDate) {
            this.hireDate = hireDate;
            return this;
        }


        // 4. 빌더 완료 메서드 선언
        public Employee build() {
            return new Employee(empId, empName, position, hireDate);
        }

    }

    // 5.빌더 호출 메서드

    public static Employee builder(){
        return new Employee();
    }


}
