package com.example.account.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.account.service.AccountService;
import com.example.account.model.Account;
import com.example.account.dto.UserNameDto;

@RestController
@RequestMapping("/users")
public class AccountController {
  private final AccountService service;

  public AccountController(AccountService service) {
    this.service = service;
  }
  
  @PostMapping
  public Account newAccount(@RequestBody UserNameDto user) {
    return service.newAccount(user.name());
  }

  @GetMapping("/{id}")
  public Account getAccount(@PathVariable long id) {
    return service.getAccount(id);
  }

  @PostMapping("/{id}/delete")
  public boolean deleteAccount(@PathVariable long id) {
    return service.deleteAccount(id);
  }

  @GetMapping
  public List<Account> getAccounts() {
    return service.getAccounts();
  }
}