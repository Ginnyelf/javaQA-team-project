package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }
    @Test
    public void shouldAddWithMinusInitialBalance() {
        CreditAccount account = new CreditAccount(
                -2,
                -2,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }


    @Test
    public void shouldAddToNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-5);

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldAddWithNotNullInInitialBalance() {
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );

        account.add(2000);

        Assertions.assertEquals(4000, account.getBalance());
    }
    @Test
    public void shouldAddOverCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(6000);

        Assertions.assertEquals(5000, account.getBalance());
    }

    @Test
    public void ifHaveMinusBalance() {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(-30, account.getBalance());
    }
    @Test
    public void ifHavePlusBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldPayToNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(-5);

        Assertions.assertEquals(0, account.getBalance());
    }
    @Test
    public void shouldPayToAmount() {
        CreditAccount account = new CreditAccount(
                4000,
                5_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(1000, account.getBalance());
    }
    @Test
    public void shouldPayToAmountWithOverLimit() {
        CreditAccount account = new CreditAccount(
                4000,
                5_000,
                15
        );

        account.pay(5000);

        Assertions.assertEquals(4000, account.getBalance());
    }
}
