package com.khai.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName; // Tên vai trò (ví dụ: ADMIN, USER)

    @OneToMany(mappedBy = "role")
    private Set<User> users; // Liên kết với bảng User (một vai trò có thể có nhiều người dùng)
}
