package org.codingsquid.jpa.controller;

import lombok.RequiredArgsConstructor;
import org.codingsquid.jpa.controller.dto.CreateAccountRequest;
import org.codingsquid.jpa.controller.dto.CreateAccountResponse;
import org.codingsquid.jpa.controller.dto.WithdrawRequest;
import org.codingsquid.jpa.controller.dto.WithdrawResponse;
import org.codingsquid.jpa.entity.Account;
import org.codingsquid.jpa.entity.User;
import org.codingsquid.jpa.service.AccountService;
import org.codingsquid.jpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@RequiredArgsConstructor
@RestController
public class AccountController {

    private final AccountService accountService;
    private final UserService userService;

    @PatchMapping("/api/v1/accounts")
    public ResponseEntity<WithdrawResponse> doWithdraw(@RequestBody WithdrawRequest request) {
        Account account = accountService.withdraw(request.getAccountNumber(), request.getMoney());
        return ResponseEntity.ok(WithdrawResponse.from(account));
    }

    @PatchMapping("/api/v2/accounts")
    public ResponseEntity<WithdrawResponse> doWithdraw2(@RequestBody WithdrawRequest request) {
        Account account = accountService.withdraw2(request.getAccountNumber(), request.getMoney());
        return ResponseEntity.ok(WithdrawResponse.from(account));
    }

    @PostMapping("/api/v1/accounts")
    public ResponseEntity<CreateAccountResponse> doCreate(@RequestBody CreateAccountRequest request) {
        User user = userService.getByEmail(request.getEmail());
        Account account = accountService.create(user);
        return ResponseEntity.ok(CreateAccountResponse.from(account));
    }
}
