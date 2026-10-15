package com.example.account.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.example.account.model.Account;

@Repository
public class InMemoryAccountRepository implements AccountRepository {
  private final List<Account> accounts = new ArrayList<>();
  AtomicLong ids = new AtomicLong(1);

  @Override
  public Account newAccount(String name) {
    Account account = new Account(ids.get(), name);
    ids.incrementAndGet();
    accounts.add(account);
    return account;
  }

  @Override
  public Account getAccount(long id) {
    Account account = accounts.stream()
      .filter(acc -> acc.getId() == id)
      .findFirst()
      .orElse(null);
    return account;
  }

  @Override
  public List<Account> getAccounts() {
    return new ArrayList<>(accounts);
  }

  @Override
  public boolean deleteAccount(long id) {
    return accounts.removeIf(account -> account.getId() == id);
  }
}