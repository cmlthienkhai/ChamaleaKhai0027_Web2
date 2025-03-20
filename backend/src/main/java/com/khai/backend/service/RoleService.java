package com.khai.backend.service;

import com.khai.backend.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    Role saveRole(Role role); // Lưu vai trò
    List<Role> getAllRoles(); // Lấy tất cả vai trò
    Optional<Role> getRoleById(Long id); // Lấy vai trò theo ID
    Optional<Role> getRoleByName(String roleName); // Lấy vai trò theo tên vai trò
    void deleteRole(Long id); // Xóa vai trò
}
