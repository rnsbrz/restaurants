package com.spring.library.service;

import com.spring.library.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
