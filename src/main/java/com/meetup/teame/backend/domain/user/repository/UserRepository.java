package com.meetup.teame.backend.domain.user.repository;

import com.meetup.teame.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByKakaoId(String kakaoId);

    Optional<User> findByEmail(String email);

}
