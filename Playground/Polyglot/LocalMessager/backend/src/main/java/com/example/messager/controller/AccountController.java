package com.example.messager.controller;

import org.springframework.web.bind.annotation.*;

import com.example.messager.service.AccountService;

import com.example.messager.model.Account;
import com.example.messager.dto.account.AccountAuthDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
@CrossOrigin(origins="*")
public class AccountController {
  private final AccountService accountService;

  @GetMapping
  public String test() {
    return "тест";
  }
  
  @PostMapping
  public Account newAccount(@RequestBody AccountAuthDto accountDto) {
    Account account = accountService.newAccount(accountDto.getName());
    return account;
  }
}