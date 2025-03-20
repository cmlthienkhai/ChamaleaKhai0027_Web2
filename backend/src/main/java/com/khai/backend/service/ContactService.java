package com.khai.backend.service;

import com.khai.backend.entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact saveContact(Contact contact); // Lưu thông tin liên hệ
    List<Contact> getAllContacts(); // Lấy tất cả thông tin liên hệ
    Optional<Contact> getContactById(Long id); // Lấy thông tin liên hệ theo ID
    void deleteContact(Long id); // Xóa thông tin liên hệ
}
