package com.example.account.service;

import org.springframework.stereotype.Service;

import java.util.List;

import com.example.account.repository.AccountRepository;
import com.example.account.model.Account;

@Service
public class AccountService {
  private final AccountRepository repository;

  public AccountService(AccountRepository repository) {
    this.repository = repository;
  }

  public Account newAccount(String name) {
    return repository.newAccount(name);
  }

  public boolean deleteAccount(long id) {
    return repository.deleteAccount(id);
  }

  public Account getAccount(long id) {
    return repository.getAccount(id);
  }

  public List<Account> getAccounts() {
    return repository.getAccounts();
  }
}