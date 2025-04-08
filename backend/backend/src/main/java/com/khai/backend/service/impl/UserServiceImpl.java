package com.khai.backend.service.impl;

import com.khai.backend.entity.User;
import com.khai.backend.repository.UserRepository;
import com.khai.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;  // Tiêm BCryptPasswordEncoder

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();  // Lấy tất cả người dùng từ cơ sở dữ liệu
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);  // Tìm người dùng theo username
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);  // Cập nhật người dùng vào cơ sở dữ liệu
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);  // Xóa người dùng theo id
    }

    @Override
    public User registerUser(User user) {
        // Kiểm tra xem username hoặc email đã tồn tại chưa
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new RuntimeException("Username already exists");
        }

        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("Email already exists");
        }

        // Mã hóa mật khẩu trước khi lưu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Lưu người dùng vào cơ sở dữ liệu
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;  // Đăng nhập thành công
        }
        throw new RuntimeException("Invalid credentials");  // Thông báo lỗi nếu đăng nhập không thành công
    }
}
