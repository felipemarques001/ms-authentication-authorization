package com.felipe.msauthenticationauthorization.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void create() {

    }

    public void findById() {

    }

    public void findAll() {

    }

    @Transactional
    public void updateById() {

    }

    @Transactional
    public void deleteById() {

    }
}
