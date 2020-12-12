package org.codingsquid.jpa.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@RequiredArgsConstructor
@Getter
public class WithdrawRequest {

    private String accountNumber;
    private BigDecimal money;
}
