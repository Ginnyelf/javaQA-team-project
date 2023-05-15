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
    public void shouldAddWithNotNullInInitialBalance() {   //// исправлено 2 (назв ишью не соотве тесту)
        CreditAccount account = new CreditAccount(
                2000,
                5_000,
                15
        );

        account.add(2000);

        Assertions.assertEquals(4000, account.getBalance());
    }

    @Test
    public void shouldAddOverCreditLimit() {   /// 5  испр
        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );

        account.add(6000);

        Assertions.assertEquals(10, account.getBalance()); /// неверный ожидаемый результат , согласно условий - Если же операция может привести к некорректном состоянию счёта, то операция должназавершиться вернув false и ничего не поменяв на счёте.
    }

    @Test
    public void ifHaveMinusBalance() {     //// 4

        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15

        );

        account.yearChange();


        Assertions.assertEquals(-30, account.yearChange());  //// замена на yearChange так как вычисляем кол-во процентов
    }

    @Test
    public void ifHavePlusBalance() {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange()); /// заменил ожидаемый результат, замена на yearChange так как вычисляем кол-во процентов
    }

    @Test
    public void shouldPayToNegativeAmount() {
        CreditAccount account = new CreditAccount(
                10,
                5_000,
                15
        );  /// //  заменил initialBalance 0 на 10

        account.pay(15);

        Assertions.assertEquals(10, account.getBalance());
    }

    @Test
    public void shouldPayToAmount() {    ///// устранено 1
        CreditAccount account = new CreditAccount(
                4000,
                5_000,
                15
        );

        account.pay(3000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldPayToAmountWithOverLimit() {   //// исправлено 3
        CreditAccount account = new CreditAccount(
                4000,
                5_000,
                15
        );

        account.pay(5000);

        Assertions.assertEquals(4000, account.getBalance());
    }
}
