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
    public void increaseNegativeBalance() {
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
    public void decreaseZeroBalance() { ///// ???????????????????
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void percentOverHundred() {
        SavingAccount account = new SavingAccount(

                2_000,
                1_000,
                10_000,
                150
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

}
