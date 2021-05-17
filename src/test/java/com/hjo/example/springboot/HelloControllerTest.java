package com.hjo.example.springboot;

import com.hjo.example.springboot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)    //Junit에 내장된 실행자 외에 다른 실행자 실행 (SpringRunner) 스프링부트 테스트와 JUnit사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class) //여러 스프링 테스트중 Web에 집중할 수 있는 어노테이션 (@Controller, @ControllerAdvice 등을 사용 가능 단, @Service, @Componet, @Respository 등은 사용 불가능)
public class HelloControllerTest {
    @Autowired  //스프링이 관리하는 빈(Bean)을 주입받는다.
    private MockMvc mvc; //웹API를 테스트할 때 사용, 스프링 MVC의 시작점, GET,POST등에 대한 API테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))  //체이닝이 지원되어 아래의 검증 기능을 이어서 선언 가능
                .andExpect(status().isOk())   //HTTP Header의 Status(200,404,500)을 검증하는데 여기선 OK인 200번인지 확인한다.
                .andExpect(content().string(hello));    //응답 본문의 내용을 검증한다. 컨트롤러에서는 "hello"를 리턴하도록 했는데 맞는지 확인한다.
        //MOCKMvc를 통해 /hello주소로 GET요청을 함
    }
}
