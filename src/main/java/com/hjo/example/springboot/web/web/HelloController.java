package com.hjo.example.springboot.web.web;

import com.hjo.example.springboot.web.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//
public class HelloController {
    @GetMapping("hello")//
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,  //외부에서 넘긴 파라미터를 가져오는 어노테이션, 여기서는 외부에서 name(@Request)이란 이름으로 넘긴 파라미터를 메소드 파라미터 name(String name)에 저장하게 됨.
                            @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}

