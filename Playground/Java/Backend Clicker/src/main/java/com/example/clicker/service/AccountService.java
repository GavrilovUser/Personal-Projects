package com.example.clicker.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.example.clicker.model.Account;
import com.example.clicker.repository.AccountRepository;


@Service
public class AccountService {
  private final AccountRepository accountRepository = new AccountRepository();
  private ArrayList<Account> accounts = accountRepository.getAccounts();
  
  public Account findById(int id) {
    return accounts.stream()
      .filter(account -> account.getId() == id)
      .findFirst()
      .orElseThrow(() -> new RuntimeException("Аккаунт не найден"));
  }

  public Account create(int balance) {
    return accountRepository.newAccount(balance);
  }
}