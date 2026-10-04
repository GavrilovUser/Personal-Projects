package com.example.bank.ui;

import java.util.Scanner;
import java.util.ArrayList;
import com.example.bank.util.Input;
import com.example.bank.model.Account;
import com.example.bank.service.AccountService;
import com.example.bank.repository.AccountRepository;

public class ConsoleUi {
  private AccountRepository accountRepository = new AccountRepository();
  private AccountService accountService = new AccountService(accountRepository);
  private ScreenDispatcher screenDispatcher = new ScreenDispatcher();
  private final Scanner scanner = new Scanner(System.in);
  private Input input = new Input(scanner);
  
  private boolean running = true;
  private boolean accountSettings = false;
  
  public void start() {
    while (running) {
      screenDispatcher.printMainMenu();
      int choice = input.readInt("Раздел [1..3]: ");
      
      switch (choice) {
        case 1 -> {
          accountsSettings();
        }
        case 2 -> {
          newAccountSection();
        }
        case 3 -> {
          screenDispatcher.closeSection();
          running = false;
        }
        default -> {
          screenDispatcher.otherSection();
        }
      }
    }
    scanner.close();
  }

  private void accountsSettings() {
    accountSettings = true;
    while (accountSettings) {
      screenDispatcher.printAccountsMenu();
      ArrayList<Account> accounts = accountRepository.getAccounts();

      if (accounts.size() == 0) {
        screenDispatcher.nullAccountsMessage();
        accountSettings = false;
      } else {
        for (Account account : accounts) {
          screenDispatcher.accountInfo(account);
        }
        
        int choice = input.readInt("Введи ID счёта: ");

        for (Account account : accounts) {
          if (account.getId() == choice) {
            accountSettingsSection(account);
            break;
          }
        }
      }
    }
  }

  private void accountSettingsSection(Account account) {
    accountSettings = true;
    while (accountSettings) {
      screenDispatcher.printAccountSettingsSection(account);
      int choice = input.readInt("Раздел [1..3]: ");
      switch (choice) {
        case 1 -> {
          String newAccountName = input.readString("Новое название: ");
          account.setName(newAccountName);
        } case 2 -> {
          double deposit = input.readDouble("Введи число: ");
          account.deposit(deposit);
        } case 3 -> {
          double withdraw = input.readDouble("Введи число: ");
          account.withdraw(withdraw);
        } case 4 -> {
          accountService.deleteAccount(account.getId());
          screenDispatcher.successDeleteMessage(account);
          accountSettings = false;
        } case 5 -> {
          accountSettings = false;
        } default -> {
          screenDispatcher.otherSection();
        }
      }
    }
  }

  private void newAccountSection() {
    String accountName = "Мой счёт";
    accountSettings = true;
    
    while (accountSettings) {
      screenDispatcher.printAccountSection(accountName);
      int choice = input.readInt("Раздел [1..3]: ");

      switch (choice) {
        case 1 -> {
          String newAccountName = input.readString("Новое название: ");
          accountName = newAccountName;
        }
        case 2 -> {
          Account newAccount = accountService.newAccount(accountName);
          screenDispatcher.finishCreateAccount();
          accountSettingsSection(newAccount);
        }
        case 3 -> {
          accountSettings = false;
        } default -> {
          screenDispatcher.otherSection();
        }
      }
    }
  }
}