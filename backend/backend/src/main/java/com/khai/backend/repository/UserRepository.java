package com.khai.backend.repository;

import com.khai.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);  // Tìm người dùng theo username
    User findByEmail(String email);        // Tìm người dùng theo email
}
