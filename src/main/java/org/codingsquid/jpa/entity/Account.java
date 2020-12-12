package org.codingsquid.jpa.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author taewoong.han
 * @since 2020.12.12
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "accounts")
public class Account {

    public static int ACCOUNT_NUMBER_SIZE = 14;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;
    private String number;
    private BigDecimal balance;

    public Account(User user, String number, BigDecimal balance) {
        this.user = user;
        this.number = number;
        this.balance = balance;
    }

    public void withdraw(BigDecimal money) {
        this.balance = this.balance.subtract(money);
    }
}
