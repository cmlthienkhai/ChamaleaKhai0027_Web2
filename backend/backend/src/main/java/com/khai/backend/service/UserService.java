package com.khai.backend.service;

import com.khai.backend.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);  // Lưu người dùng
    List<User> getAllUsers();  // Lấy tất cả người dùng
    User getUserByUsername(String username);  // Tìm người dùng theo username
    User updateUser(User user);  // Cập nhật thông tin người dùng
    void deleteUser(Long id);  // Xóa người dùng
    User registerUser(User user);  // Đăng ký người dùng
    User loginUser(String username, String password);  // Đăng nhập người dùng
}
