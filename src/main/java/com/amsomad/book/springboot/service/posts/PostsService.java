package com.amsomad.book.springboot.service.posts;


import com.amsomad.book.springboot.domain.posts.Posts;
import com.amsomad.book.springboot.domain.posts.PostsRepository;
import com.amsomad.book.springboot.web.dto.PostsListResponseDto;
import com.amsomad.book.springboot.web.dto.PostsResponseDto;
import com.amsomad.book.springboot.web.dto.PostsSaveRequestDto;
import com.amsomad.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시믈이 없습니다. id = " + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시믈이 없습니다. id = " + id));
        postsRepository.delete(posts);

    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                // 이건 .map(posts -> new PostsListResponseDto(posts))
                // postsRepository 의 리턴된 Posts의 Stream을 Map으로 Dto로 변환하여 List로 반환
                .collect(Collectors.toList());
    }

}
