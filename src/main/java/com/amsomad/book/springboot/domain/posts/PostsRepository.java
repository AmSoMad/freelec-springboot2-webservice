package com.amsomad.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // JpaRepository<entity 클래스, pk타입>
    /*
    @Repository 없어도됌
    단 entity 클래스와 Repository 인터페이스는 같은폴더에 위치해야한다.
    또한 entity클랙스는 Repository 없으면 그냥 의미없는 클래스
     */


}
