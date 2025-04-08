package com.khai.backend.service.impl;

import com.khai.backend.entity.Contact;
import com.khai.backend.repository.ContactRepository;
import com.khai.backend.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact); // Lưu thông tin liên hệ
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll(); // Lấy tất cả thông tin liên hệ
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id); // Lấy thông tin liên hệ theo ID
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id); // Xóa thông tin liên hệ theo ID
    }
}
