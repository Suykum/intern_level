package ru.job4j.bank;

import java.util.*;

public class BankOperations {
    private Map<User, List<Account>> userAccount = new HashMap<>();

    public void addUser(User user) {
        userAccount.putIfAbsent(user, new ArrayList<>());

    }
    public void deleteUser(User user) {
        userAccount.remove(user);

    }
    public void addAccountToUser(String passport, Account account) {
        User user = findUserByPass(passport);
        if (user != null) {
            userAccount.get(user).add(account);
        }
    }
    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUserByPass(passport);
        if (user != null) {
            userAccount.get(user).remove(account);
        }
    }

    public List<Account> getUserAccounts (String passport) {
        User user = findUserByPass(passport);
        List<Account> userAccountList = null;
        if (user != null) {
            userAccountList = userAccount.get(user);
        }
        return userAccountList;
    }
    public boolean transferMoney (String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean resultOfTransfer = false;
        Account srcAccount = getAccount(srcPassport, srcRequisite);
        Account desAccount = getAccount(destPassport, destRequisite);
        if (srcAccount.getValue() >= amount) {
            double beforeSend = srcAccount.getValue();
            srcAccount.setValue(beforeSend - amount);

            double beforeReceive = desAccount.getValue();
            desAccount.setValue(beforeReceive + amount);
            resultOfTransfer = true;
        }
        return resultOfTransfer;
    }
    public Account getAccount(String pass, String requisite) {
        Account currentAccount = null;
        List<Account> userAccountList = getUserAccounts(pass);
        for (Account account : userAccountList) {
            if (account.getRequisites() == requisite) {
                currentAccount = account;
            }
        }
        return currentAccount;
    }

    public User findUserByPass(String passport) {
        User user = null;
        Set<Map.Entry<User, List<Account>>> userAccountSet = userAccount.entrySet();
        for (Map.Entry<User, List<Account>> element : userAccountSet) {
            if (element.getKey().getPassport() == passport) {
                user = element.getKey();
                break;
            }
        }
        return user;
    }
    public int size() {
        return userAccount.size();
    }
}
