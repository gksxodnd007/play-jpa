package org.codingsquid.jpa.repository;

import org.codingsquid.jpa.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByNumber(String number);
}
