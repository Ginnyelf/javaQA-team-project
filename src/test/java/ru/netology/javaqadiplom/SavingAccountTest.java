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
    public void increaseOnZeroBalance() {
        SavingAccount account = new SavingAccount(
                9_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(9_000, account.getBalance());
    }

    @Test
    public void addCheckingNegativeAmount() {
        SavingAccount account = new SavingAccount(
                6_000,
                1_000,
                10_000,
                5
        );

        account.add(-1000);

        Assertions.assertEquals(6_000, account.getBalance());
    }

    @Test
    public void increaseBalanceLimitValue() {      /////// bag
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        Assertions.assertEquals(10_000, account.getBalance());
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
    public void maxBalanceLessMinBalance() {
        SavingAccount account = new SavingAccount(
                4_000,
                10_000,
                7_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(7000, account.getBalance());
    }

    @Test
    public void initBalanceLessMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                4_000,
                10_000,
                5
        );

        account.add(2_000);

        Assertions.assertEquals(4000, account.getBalance());
    }


    @Test
    public void payAmountEqualsZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(0);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void payAmountNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-1000);

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
    public void checkingNegativeMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                -2_000,
                10_000,
                5
        );

        account.pay(3000);

        Assertions.assertEquals(2000, account.getBalance());
    }

    @Test
    public void ShouldPay() {
        SavingAccount account = new SavingAccount(
                4_000,
                1_000,
                10_000,
                5
        );

        account.pay(1_000);

        Assertions.assertEquals(3000, account.getBalance());
    }

    @Test
    public void checkingLimitPay() {
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
    public void payLessLimit() {
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
    public void checkingMinBalanceEqualsMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                2_000,
                2_000,
                5
        );

        account.pay(1000);

        Assertions.assertEquals(2000, account.getBalance());
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

    @Test
    public void WhenRateIsZero() {
        SavingAccount account = new SavingAccount(

                200,
                200,
                10_000,
                0
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

}
