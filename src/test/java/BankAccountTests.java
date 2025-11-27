import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTests {
    @Test
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);

        assertEquals( 200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 300 successfully")
    public void testDeposit() throws InterruptedException {
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.deposit(300);
        assertEquals(800, bankAccount.getBalance());
    }
    @Test
    @DisplayName("Withdraw 300 successfully")
    public void testWithdrawal(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw a negative amount")
    public void testTransfer(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertThrows(IllegalArgumentException.class, () -> bankAccount.deposit(-300));
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(700);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test activation of account after creation")
    public void testActivation(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set account holder name")
    public void testSetAccountHolderName(){
        BankAccount bankAccount = new BankAccount(500, 0);
        bankAccount.setAccountHolder("Account Holder");
        assertNotNull(bankAccount.getAccountHolder());
    }

    @Test
    @DisplayName("Test can't withdraw below minimum")
    public void testWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(600));
    }

    @Test
    @DisplayName("Test no exceptions for withdrawal and deposit")
    public void testNoExceptions(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertAll(()-> bankAccount.withdraw(300), ()-> bankAccount.deposit(300));
    }

    @Test
    @DisplayName("Test Speed deposit")
    public void testAssertTimeOut(){
        BankAccount bankAccount = new BankAccount(500, 0);
        assertTimeout(Duration.ofMillis(20), ()-> bankAccount.deposit(300));
        assertEquals(0.33, (double) 1 /3, 0.01);
    }
}
