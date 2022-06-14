package edu.mum.cs.cs525.labs.exercises.project.ui.framework.account;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.ObserverPattern.Observer;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.ObserverPattern.Subject;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.account_type.AccountType;

import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.customer.Client;
import edu.mum.cs.cs525.labs.exercises.project.ui.framework.account.interest_strategy.InterestStrategy;

public class AccountImpl implements Account , Subject {
    private AccountType accountType;
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

    private Transaction createTransaction(String description, double amount){
        Transaction transaction = new Transaction(LocalDate.now(), description, amount);
        transactions.add(transaction);
        return transaction;
    }

    private AccountImpl() {}

    @Override
    public Transaction deposit(double amount) {
        balance += amount;
        return createTransaction("DEPOSIT", amount);
    }

    @Override
    public Transaction withdraw(double amount) {
        balance -= amount;

        return createTransaction("WITHDRAW", amount);
    }

    @Override
    public void addInterest() {
         balance += interestStrategy.calculateInterest(balance);
    }
//Observer Send Email

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }


    @Override
    public void registerObserver(Observer o) {
      //  observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
       // observers.remove(o);
    }

    @Override
    public void notifyObservers() {

        //observers.forEach(o -> o.update(getBalance()));
    }



    // Builder

    static class Builder{
        String accountNumber;
        AccountType accountType;
        InterestStrategy interestStrategy;
        public Builder(String accountNumber, AccountType accountType, InterestStrategy interestStrategy){
            this.accountType = accountType;
            this.accountNumber = accountNumber;
            this.interestStrategy = interestStrategy;
        }

        public Builder customer(Client client){
            return this;
        }

        public Account build(){
            AccountImpl account = new AccountImpl();
            account.accountNumber = accountNumber;
            account.accountType = accountType;
            account.interestStrategy = interestStrategy;
            return account;
        }
    }

}
