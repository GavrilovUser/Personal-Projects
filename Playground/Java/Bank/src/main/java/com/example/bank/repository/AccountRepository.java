package com.example.bank.repository;

import com.example.bank.model.Account;
import java.util.ArrayList;

public class AccountRepository {
  private ArrayList<Account> accounts = new ArrayList<>();
  private int ids = 1;

  public int getIds() {
    return ids;
  }

  public ArrayList getAccounts() {
    return accounts;
  }

  public void addAccount(Account account) {
    accounts.add(account);
    ids++;
  }

  public void deleteAccount(int id) {
    accounts.removeIf(account -> account.getId() == id);
  }
}