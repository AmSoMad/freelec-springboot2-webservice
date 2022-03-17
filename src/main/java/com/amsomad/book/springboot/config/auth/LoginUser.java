package com.amsomad.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 어노테이션이 생성될위치지정 파라미터로했으니 메소드의 파라미터의 객체만 사용가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    //@interface 어노테이션 파일로 지정
    //LoginUser 란 어노테이션이 생성됌
}
