package com.amsomad.book.springboot.config;

import com.amsomad.book.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers){
        //HandlerMethodArgumentResolver 는 항상 WebMvcConfigurer의 addArgumentResolvers로 추가해야한다.
        argumentResolvers.add(loginUserArgumentResolver);

        //Handler-MethodArgumentResolver가 필요하면 같은방식으로 추가하면된다.

    }


}
