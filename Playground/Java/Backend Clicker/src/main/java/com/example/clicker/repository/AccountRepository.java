package com.example.clicker.repository;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;
import com.example.clicker.model.Account;

@Repository
public class AccountRepository {
  private final ArrayList<Account> accounts = new ArrayList<>();
  private int ids = 1;
  
  public Account newAccount(int balance) {
    Account account = new Account(balance, ids);
    ids++;
    accounts.add(account);
    
    return account;
  }

  public ArrayList<Account> getAccounts() {
    return accounts;
  }
}