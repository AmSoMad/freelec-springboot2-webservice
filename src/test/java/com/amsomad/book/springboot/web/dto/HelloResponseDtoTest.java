package com.amsomad.book.springboot.web.dto;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given

        String name = "암소메애";
        int amount = 2000;
        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);
        //then
        assertThat(dto.getName()).isEqualTo(name).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertj 테스트 검증 라이브러리
        //메소드 체이닝 지원되어 isEqualTo 로 계속 이어서 사용가능

        //junit 에도 assertThat이 있다
        //왜 쓰는지는 백기선님껄 보자.
    }
}
