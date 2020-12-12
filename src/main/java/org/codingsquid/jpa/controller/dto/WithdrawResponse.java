package org.codingsquid.jpa.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.codingsquid.jpa.entity.Account;

import java.math.BigDecimal;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@RequiredArgsConstructor
@Getter
public class WithdrawResponse {

    private final String accountNumber;
    private final BigDecimal balance;

    public static WithdrawResponse from(Account entity) {
        return new WithdrawResponse(entity.getNumber(), entity.getBalance());
    }
}
