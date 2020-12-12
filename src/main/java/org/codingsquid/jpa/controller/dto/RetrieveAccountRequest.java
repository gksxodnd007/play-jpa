package org.codingsquid.jpa.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@RequiredArgsConstructor
@Getter
public class RetrieveAccountRequest {

    private final String accountNumber;
}
