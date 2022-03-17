package com.amsomad.book.springboot.domain.posts;

import com.amsomad.book.springboot.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    // findByEmail 해당이메일로 생성된 사용자인지 처음가입자인지 판단하는 메소드
}
