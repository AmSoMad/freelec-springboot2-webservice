package com.amsomad.book.springboot.config.auth;

import com.amsomad.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //컨트롤러 매서드의 특정 파라미터를 지원하는지 판단
        // @LoginUser 어노테이션이 있고, 파라미터 클래스타입이 SessionUser.class 일경우 true를 반환
        
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        //파라미터에 loginUser.class 어노테이션이 있으면 true 없으면 null;

        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());
        //파라미터 클래스타입이 SessionUser.class일경우 true

        return isLoginUserAnnotation && isUserClass; //둘다있으면 true
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //파라미터에 전달할 객체생성
        //세션에서 객체를 가져온다.
        return httpSession.getAttribute("user");
        
    }
}
