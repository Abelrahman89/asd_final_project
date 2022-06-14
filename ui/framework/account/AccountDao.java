package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;

import java.util.List;

public interface AccountDao {
    void saveAccount(Account account);
    Account getAccountByAccountNumber(String accountNumber);
    List<Account> getAllAccounts();
}
