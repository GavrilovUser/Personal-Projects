package com.example.bank.service;

import com.example.bank.model.Account;
import com.example.bank.repository.AccountRepository;
import java.util.ArrayList;

public class AccountService {
  private AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public AccountRepository getAccounts() {
    return accountRepository;
  }

  public Account newAccount(String accountName) {
    Account account = new Account(accountName, accountRepository.getIds());
    accountRepository.addAccount(account);
    return account;
  }

  public void deleteAccount(int id) {
    accountRepository.deleteAccount(id);
  }
}