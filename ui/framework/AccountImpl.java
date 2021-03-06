package edu.mum.cs.cs525.labs.exercises.project.ui.framework;

import java.io.Serial;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account_type_strategy.AccountTypeStrategy;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.customer.Client;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.interest_strategy.InterestStrategy;


public class AccountImpl implements Account {
    @Serial
    private static final long serialVersionUID = 20220615L;

    private AccountTypeStrategy accountType;
    private Client client;

    @Override
    public AccountTypeStrategy getAccountType() {
        return accountType;
    }

    @Override
    public InterestStrategy getInterestStrategy() {
        return interestStrategy;
    }


    private InterestStrategy interestStrategy;
    private List<Transaction> transactions = new ArrayList<>();
    private String accountNumber;

    private double balance = 0;

    public double getBalance() {
        return balance;
    }



    @Override
    public String toString() {
        return "AccountImpl{" +
                "accountType=" + accountType +
                ", interestStrategy=" + interestStrategy +
                ", transactions=" + transactions +
                ", accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }

    private Transaction createTransaction(String description, double amount) {
        Transaction transaction = new Transaction(LocalDate.now(), description, amount);
        transactions.add(transaction);
        return transaction;
    }

    AccountImpl(Client client, String accountNumber, AccountTypeStrategy accountType, InterestStrategy strategy) {
        this.client = client;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.interestStrategy = strategy;
    }

    @Override
    public Transaction deposit(double amount) {
        balance += amount;
        return createTransaction("DEPOSIT", amount);
    }

    @Override

    public Transaction withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return createTransaction("WITHDRAW", amount);
        }
        return null;

    }

    @Override
    public void addInterest() {
        balance += interestStrategy.calculateInterest(balance);

    }
    // Observer Send Email

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }


    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public Client getClient() {
        return client;
    }

    // Builder

//    static class Builder {
//        String accountNumber;
//        AccountTypeStrategy accountType;
//        InterestStrategy interestStrategy;
//        Client client;
//
//        public Builder(Client client, String accountNumber, AccountTypeStrategy accountType, InterestStrategy interestStrategy) {
//            this.client = client;
//            this.accountType = accountType;
//            this.accountNumber = accountNumber;
//            this.interestStrategy = interestStrategy;
//        }
//
//        public Builder customer(Client client) {
//            return this;
//        }
//
//        public Account build() {
//            AccountImpl account = new AccountImpl();
//            account.accountNumber = accountNumber;
//            account.accountType = accountType;
//            account.interestStrategy = interestStrategy;
//            account.client = client;
//            return account;
//        }
//
//
//    }

}
