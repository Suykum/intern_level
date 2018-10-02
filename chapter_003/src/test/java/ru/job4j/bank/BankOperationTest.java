package ru.job4j.bank;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankOperationTest {
    BankOperations bankOperations = new BankOperations();
    @Before
    public void beforeTest() {
        User user1 = new User("Anna Hols", "P11111");
        User user2 = new User("German Hols", "P22222");
        User user3 = new User("Tina Anders", "P33333");
        bankOperations.addUser(user1);
        bankOperations.addUser(user2);
        bankOperations.addUser(user3);
    }
    @Test
    public void whenNewUserAdded() {
    User resultUser = bankOperations.findUserByPass("P22222");
    resultUser.getName();
    assertThat(resultUser.getName(), is("German Hols"));
    }
    @Test
    public void whendeletingUser() {
        System.out.println(bankOperations.size());
        bankOperations.deleteUser(bankOperations.findUserByPass("P33333"));
        assertThat(bankOperations.size(), is(2));
    }
    @Test
    public void whenAddAccountToUser() {
        bankOperations.addAccountToUser("P11111", new Account(1000.0, "R7777777"));
        assertThat(bankOperations.getUserAccounts("P11111").get(0).getRequisites(), is("R7777777"));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Account account1 = new Account(1000.0, "R7777777");
        Account account2 = new Account(2000.0, "R8888888");
        bankOperations.addAccountToUser("P11111", account1);
        bankOperations.addAccountToUser("P11111", account2);
        System.out.println("Number of accounts before deleting " + bankOperations.getUserAccounts("P11111").size());
        bankOperations.deleteAccountFromUser("P11111", account1);
        System.out.println("Number of accounts after deleting " + bankOperations.getUserAccounts("P11111").size());

    }

    @Test
    public void whenTransfer100() {
        bankOperations.addAccountToUser("P11111", new Account(1000.0, "R7777777"));
        bankOperations.addAccountToUser("P22222", new Account(0.0, "R0000000"));
        bankOperations.transferMoney("P11111", "R7777777", "P22222", "R0000000", 100.0);
        assertThat(bankOperations.getUserAccounts("P11111").get(0).getValue(), is(900.0));
    }
}
