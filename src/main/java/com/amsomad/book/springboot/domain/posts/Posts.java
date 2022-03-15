package com.amsomad.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor //기본 생성자 자동추가
@Entity // 테이블과 링크될 클래스 카멜메이스이름을 언더스코어 _ 으로 테이블 이름을 매칭함
public class Posts {

    /*
    Entity 클래스에는 Setter 가 없다.
    죽었다깨도 안만든다.
     */
    @Id //pk 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY) //pk 생성규칙 GenerationType.IDENTITY -> auto_increment 된다.
    private Long id;

    @Column(length = 500, nullable = false) //기본적으로 varchar(255)가 기본값이다
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String toString(){
        String result ="id : "+ id + " / title : " + title + " / content : " + content + " / author : " + author;
        return result;
    }

}
