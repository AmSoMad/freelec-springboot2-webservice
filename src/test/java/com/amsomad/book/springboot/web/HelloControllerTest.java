package com.amsomad.book.springboot.web;

import com.amsomad.book.springboot.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc; //웹 api 테스트 시작점 get post api 테스트

    @Test
    public void hello가_리턴된다() throws Exception {

        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk()) //200 404 500 상태검증
                .andExpect(content().string(hello)); // String hello 를 리턴하는지 검증
    }

    @Test
    public void Dto가_리턴된다() throws Exception {

        String name = "암소메애";
        int amount = 2000;
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                //.andExpect(content().string(name))
                //.andExpect(content().string(String.valueOf(amount)));
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

        //웹에서 파라미터로 날릴때는 전부 문자열로 넘어오기때문에 바꿔야 한다.
    }

}
