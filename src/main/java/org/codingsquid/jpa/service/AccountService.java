package org.codingsquid.jpa.service;

import lombok.RequiredArgsConstructor;
import org.codingsquid.jpa.entity.Account;
import org.codingsquid.jpa.entity.User;
import org.codingsquid.jpa.repository.AccountRepository;
import org.codingsquid.jpa.utils.RandomUtils;
import org.codingsquid.jpa.utils.ThreadUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository repository;
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Account findTwiceByAccountNumber(String accountNumber) {
        System.out.println(">>> findTwiceByAccountNumber");
        Account account = repository.findByNumber(accountNumber)
                .orElseThrow(RuntimeException::new);

        System.out.println(">>> account number: " + account.getNumber() + " balance: " + account.getBalance());

        ThreadUtils.sleep(5000);

        // entityManager.clear(); // 주석 해제후 실행하면 원하는 동작을 하게됨.
        // db를 조회 후 영속성 컨텍스트에 해당 id를 가지는 Account가 존재하므로 db에서 조회한 값은 버리고 영속성 컨텍스트에 있는 entity를 사용
        Account afterAccount = repository.findByNumber(accountNumber)
                .orElseThrow(RuntimeException::new);
        System.out.println(">>> after account number: " + afterAccount.getNumber() + " balance: " + afterAccount.getBalance());

        return afterAccount;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public Account withdraw(String accountNumber, BigDecimal money) {
        System.out.println(">>> withdraw");
        Account account = repository.findByNumber(accountNumber)
                .orElseThrow(RuntimeException::new);

        account.withdraw(money);
        return repository.save(account);
    }

    @Transactional
    public Account create(User user) {
        String newAccountNumber = RandomUtils.generateNumber();
        Account account = new Account(user, newAccountNumber, BigDecimal.ZERO);
        return repository.save(account);
    }
}
