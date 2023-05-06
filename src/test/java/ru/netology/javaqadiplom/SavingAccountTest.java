package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {


    @Test
    public void increaseBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void WhenInitialBalanceIsNegative() {
        SavingAccount account = new SavingAccount(
                -1_000,
                1_000,
                10_000,
                5
        );

        account.add(500);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void increaseZeroBalance() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );

        account.add(500);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void WhenAfterAddOverMaxLimit() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(10000);

        Assertions.assertEquals(2000, account.getBalance());
    }


    @Test
    public void decreaseBalanceLessMinLimit() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(2000, account.getBalance());
    }
    @Test
    public void ShouldPay() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(1000, account.getBalance());
    }


    @Test
    public void shouldCalculateSumOfPercent() {
        SavingAccount account = new SavingAccount(

                200,
                200,
                10_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(30, account.yearChange());
    }

    @Test
    public void WhenRateIsNegative() {
        SavingAccount account = new SavingAccount(

                200,
                200,
                10_000,
                -15
        );

        account.yearChange();

        Assertions.assertEquals(200, account.yearChange());
    }

}
