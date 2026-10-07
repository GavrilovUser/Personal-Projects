package com.example.clicker.controller;

import org.springframework.web.bind.annotation.*;

import com.example.clicker.model.Account;
import com.example.clicker.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class BalanceController {
  private final AccountService accountService;

  public BalanceController(AccountService accountService) {
    this.accountService = accountService;
  }
  
  @PostMapping
  public Account newAccount() {
    int balance = 0;
    Account account = accountService.create(balance);
    return account;
  }

  @GetMapping("/{id}")
  public Account getById(@PathVariable int id) {
    Account account = accountService.findById(id);
    return account;
  }

  @PostMapping("/{id}")
  public Account addBalance(@PathVariable int id) {
    Account account = accountService.findById(id);
    account.addBalance();
    return account;
  }
}