package com.maybach7.gweather.services;

import com.maybach7.gweather.models.User;
import com.maybach7.gweather.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public boolean checkPassword(String username, String password) {
        log.info("Checking password for user {}, {}", username, password);

        String realPassword = userRepository.findByUsername(username).get().getPassword();
        log.info("Real hashed password: {}", realPassword);

        String hashedPassword = passwordEncoder.encode(password);
        log.info("New hashed password: {}", hashedPassword);

        return passwordEncoder.matches(password, realPassword);
    }

    public User changePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));
        return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}