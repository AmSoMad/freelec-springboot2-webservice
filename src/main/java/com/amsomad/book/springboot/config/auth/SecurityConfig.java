package com.amsomad.book.springboot.config.auth;

import com.amsomad.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //이건 Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                //이건 h2-console. 화면사용을위해 disable함
                .and()
                    .authorizeRequests()
                    .antMatchers(
                            "/"
                            ,"/css/**"
                            ,"/images/**"
                            ,"/js/**"
                            ,"/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    .anyRequest().authenticated()
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                        //로그아웃시 "/"로 
                        //로그아웃의 기능설정지점
                .and()
                    .oauth2Login()
                    //oauth2 로그인시 설정지점
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);
                            //소셜로그인 성공후 진행할 인터페이스 등록
                            //정보 받아오면 뭐할꺼야? 저장을하자
    }



}
