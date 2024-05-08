package com.meetup.teame.backend.domain.register.service;

import com.meetup.teame.backend.domain.register.dto.RegisterRequest;
import com.meetup.teame.backend.domain.user.repository.UserRepository;
import com.meetup.teame.backend.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class RegisterService {

    private final UserService userService;
    private final BCryptPasswordEncoder encoder;

    /**
     * 회원가입
     * client에게 RegisterRequest(name,email,password,location)를 입력 받아 비밀번호 암호화 후 저장
     * email, userName 중복체크는 안 할 예정
     */
    public Long register(RegisterRequest request) {
        String encodedPassword = encoder.encode(request.getPassword());
        int currentYear = LocalDate.now().getYear();
        int birthYear = Integer.parseInt(request.getBirthyear());
        long age = currentYear - birthYear + 1;
        return userService.save(request.toEntity(request,encodedPassword, age));
    }

}
