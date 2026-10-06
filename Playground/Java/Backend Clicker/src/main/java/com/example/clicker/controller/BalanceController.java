package com.example.clicker.controller;

import org.springframework.web.bind.annotation.*;

import com.example.clicker.model.Account;

@RestController
@RequestMapping("/api")
public class BalanceController {
  private Account account = new Account(0);

  @GetMapping("/balance")
  public Account getBalance() {
    return account;
  }

  @PostMapping("/click")
  public Account click() {
    account.addBalance();
    return account;
  }
}