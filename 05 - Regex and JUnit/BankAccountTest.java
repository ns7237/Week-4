package utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    public void testDepositIncreasesBalance() {
        BankAccount account = new BankAccount();
        account.deposit(1000);
        assertEquals(1000, account.getBalance());
    }

    @Test
    public void testWithdrawDecreasesBalance() {
        BankAccount account = new BankAccount();
        account.deposit(1000);
        account.withdraw(400);
        assertEquals(600, account.getBalance());
    }

    @Test
    public void testWithdrawFailsIfInsufficientFunds() {
        BankAccount account = new BankAccount();
        account.deposit(500);
        account.withdraw(600);
        assertEquals(500, account.getBalance()); // No change
    }
}
