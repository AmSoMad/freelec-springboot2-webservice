package com.amsomad.book.springboot.web.domain.posts;

import com.amsomad.book.springboot.domain.posts.Posts;
import com.amsomad.book.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {
    
    @Autowired
    PostsRepository postsRepository;
    
    @After //이건 단위테스트 끝난후 수행되는 메소드
    public void cleanup(){
        postsRepository.deleteAll();
    }
    
    @Test
    public void 게시글저장_불로오기(){
        //given
        String title = "게시물제목";
        String content = "본문";
        
        postsRepository.save((Posts.builder()
                .title(title)
                .content(content)
                .author("lsun000@naver.com")
                .build()));
        //조심하자 Id 값이 있으면 update가 이루어진다. 허나
        //없을경우 insert 가된다.
        
        //when
        List<Posts> postsList = postsRepository.findAll();
        
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        
        
    }
    
}
