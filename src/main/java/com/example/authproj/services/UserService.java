package com.example.authproj.services;

import com.example.authproj.models.User;
import com.example.authproj.models.enums.Role;
import com.example.authproj.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(User user) {
        String username = user.getUsername();
        if (userRepository.findByUsername(username) != null) return false;
        user.setUsername(username);
        user.setActive(true);
        user.getRoles().add(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

//    public boolean createAdmin() {
//        User user = new User();
//
//        String username = "eljur_admin";
//        String password = "13071830";
//
//        if (userRepository.findByUsername(username) != null) return false;
//        user.setUsername(username);
//        user.setActive(true);
//        user.getRoles().add(Role.ROLE_ADMIN);
//        user.setPassword(passwordEncoder.encode(password));
//        userRepository.save(user);
//        return true;
//    }
}
