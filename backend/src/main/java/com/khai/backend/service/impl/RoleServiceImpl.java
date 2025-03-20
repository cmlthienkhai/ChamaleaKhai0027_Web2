package com.khai.backend.service.impl;

import com.khai.backend.entity.Role;
import com.khai.backend.repository.RoleRepository;
import com.khai.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role); // Lưu vai trò
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll(); // Lấy tất cả vai trò
    }

    @Override
    public Optional<Role> getRoleById(Long id) {
        return roleRepository.findById(id); // Lấy vai trò theo ID
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        return roleRepository.findByRoleName(roleName); // Lấy vai trò theo tên vai trò
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id); // Xóa vai trò
    }
}
