package com.example.mvc.chap06;

import com.example.mvc.jdbc.Person;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping("/rests")
public class RestApiController {

    @GetMapping("/hello")
    public String hello() {
        return "안녕하세요~!!";
    }

    @GetMapping("/foods")
    public String[] foods() {
        String[] foodList = {"탕수육", "족발", "피자"};
        return foodList;
    }

    @GetMapping("/foods-list")
    //리턴 하는 값 그대로 가져갈때 사용
    public List<String> foodsList() {
        List<String> foodList1 = List.of("탕수육", "족발", "피자");
        return foodList1;
    }

    @GetMapping("/person")
    public Person person() {
        Person p = new Person(1L, "루피", 3);
        return p;
    }

    @GetMapping("/person-list")
    public ResponseEntity<?> personList() {
        Person p1 = new Person(1L, "루피", 3);
        Person p2 = new Person(2L, "딸긔겅듀", 4);
        Person p3 = new Person(3L, "뽈롤로", 5);
        List<Person> personList= List.of(p1, p2, p3);

        return ResponseEntity.ok().body(personList);


    }

    @GetMapping("/bmi")
    public ResponseEntity<?> bmi(
            @RequestParam(required = false) Double cm,
            @RequestParam(required = false) Double kg) {

        if (cm == null || kg == null) {
            return ResponseEntity.badRequest().build();
//            글씨보낼거면
//            return ResponseEntity.badRequest().body("여기다가 클라에 뿌릴 글");
        }

        double bmi = kg / (cm / 100) * (cm / 100);

        // 헤더를 추가하려면 이런식으로 하면 됨
        HttpHeaders headers = new HttpHeaders();

        headers.add("fruits", "melon");
        headers.add("hobby", "soccer");

        return ResponseEntity.ok()
                .headers(headers)
                .body(bmi);

    }


}
