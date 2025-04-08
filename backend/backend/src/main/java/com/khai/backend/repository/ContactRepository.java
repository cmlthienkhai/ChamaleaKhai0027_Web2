package com.khai.backend.repository;

import com.khai.backend.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // Tạo thêm các phương thức tùy chỉnh nếu cần
}
