package com.example.messager.repository.account;

import org.springframework.stereotype.Repository;

import com.example.messager.model.Account;

import java.util.List;
import java.util.ArrayList;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryAccountRepository implements AccountRepository {
  private final List<Account> accounts = new ArrayList<>();
  private AtomicLong ids = new AtomicLong(0);
  
  @Override
  public Account newAccount(String name) {
    long accountId = ids.incrementAndGet();
    Account account = new Account(accountId, name);
    accounts.add(account);
    return account;
  }
}