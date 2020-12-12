package org.codingsquid.jpa.controller.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@RequiredArgsConstructor
@Getter
public class CreateAccountRequest {

    private final String username;
    private final String email;
}
