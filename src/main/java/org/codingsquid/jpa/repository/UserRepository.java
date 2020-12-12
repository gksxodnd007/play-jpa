package org.codingsquid.jpa.repository;

import org.codingsquid.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
