package com.example.messager.repository.account;

import com.example.messager.model.Account;

public interface AccountRepository {
  Account newAccount(String name);
}