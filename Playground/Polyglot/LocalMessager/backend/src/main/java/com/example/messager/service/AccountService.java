package com.example.messager.service;

import org.springframework.stereotype.Service;

import com.example.messager.repository.account.AccountRepository;

import com.example.messager.model.Account;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AccountService {
  private final AccountRepository accountRepository;

  public Account newAccount(String name) {
    Account account = accountRepository.newAccount(name);
    return account;
  }
}