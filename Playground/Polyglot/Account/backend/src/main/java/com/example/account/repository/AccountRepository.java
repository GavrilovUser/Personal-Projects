package com.example.account.repository;

import java.util.List;

import com.example.account.model.Account;

public interface AccountRepository {
  Account newAccount(String name);
  Account getAccount(long id);
  List<Account> getAccounts();
  boolean deleteAccount(long id);
}