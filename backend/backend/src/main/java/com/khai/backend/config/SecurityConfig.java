package com.khai.backend.config;  // Đảm bảo package chính xác

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration  // Đảm bảo rằng lớp này được Spring nhận diện
public class SecurityConfig {

    @Bean  // Đánh dấu phương thức này là một Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();  // Trả về đối tượng BCryptPasswordEncoder
    }
}
