package org.codingsquid.jpa.controller.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Getter
public class WithdrawRequest {

    private final String accountNumber;
    private final BigDecimal money;
}
