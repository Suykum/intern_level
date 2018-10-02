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
        User srcUser = findUserByPass(srcPassport);
        User dstUser = findUserByPass(destPassport);
        int srcAccountIndex = getAccountIndex(srcUser, srcRequisite);
        int desAccountIndex = getAccountIndex(dstUser, destRequisite);

        if (userAccount.get(srcUser).get(srcAccountIndex).getValue() >= amount) {
            double beforeSend = userAccount.get(srcUser).get(srcAccountIndex).getValue();
            userAccount.get(srcUser).get(srcAccountIndex).setValue(beforeSend - amount);

            double beforeResive = userAccount.get(dstUser).get(desAccountIndex).getValue();
            userAccount.get(dstUser).get(desAccountIndex).setValue(beforeResive + amount);
            resultOfTransfer = true;
        }
        return resultOfTransfer;
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

    public int getAccountIndex(User user, String requisite) {
        int index = 0;
        for (int i = 0; i < userAccount.get(user).size(); i++) {
            if (userAccount.get(user).get(i).getRequisites() == requisite) {
                index = i;
            }
        }
        return index;
    }
    public int size() {
        return userAccount.size();
    }
}
