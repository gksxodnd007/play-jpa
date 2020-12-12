package org.codingsquid.jpa.service;

import lombok.RequiredArgsConstructor;
import org.codingsquid.jpa.entity.User;
import org.codingsquid.jpa.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(RuntimeException::new);
    }

    public User register(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user);
    }
}
