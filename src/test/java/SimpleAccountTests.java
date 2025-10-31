import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleAccountTests {

    @Test
    public void testAdd(){
        // given
        SimpleAccount simpleAccount = new SimpleAccount();
        long amount = 120_000;
        boolean expectedRes = true;

        // when
        boolean res = simpleAccount.add(amount);
        long balance = simpleAccount.getBalance();

        // then
        Assertions.assertEquals(expectedRes, res);
        Assertions.assertEquals(amount, balance);
    }

    @Test
    public void testPay(){
        // given
        SimpleAccount simpleAccount = new SimpleAccount();
        long payAmount = 50_000, expectedBalance = 70_000;
        boolean expectedRes = true;

        // when
        simpleAccount.add(120_000);
        boolean res = simpleAccount.pay(50_000);
        long balance = simpleAccount.getBalance();

        // then
        Assertions.assertEquals(expectedRes, res);
        Assertions.assertEquals(expectedBalance, balance);
    }

    @Test
    public void testTransfer(){
        // given
        SimpleAccount account1 = new SimpleAccount();
        SimpleAccount account2 = new SimpleAccount();
        long account1StartBalance = 50_000, transferAmount = 20_000, expectedAccount1Balance = 30_000;

        boolean expectedTransferRes = true;

        // when
        account1.add(account1StartBalance);
        boolean res = account1.transfer(account2, transferAmount);
        long account1Balance = account1.getBalance();
        long account2Balance = account2.getBalance();

        // then
        Assertions.assertEquals(expectedTransferRes, res);
        Assertions.assertEquals(expectedAccount1Balance, account1Balance);
        Assertions.assertEquals(transferAmount, account2Balance);
    }
}
