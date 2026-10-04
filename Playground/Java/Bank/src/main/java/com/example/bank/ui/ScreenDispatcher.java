package com.example.bank.ui;

import java.util.ArrayList;
import com.example.bank.util.Input;
import com.example.bank.model.Account;
import com.example.bank.service.AccountService;
import com.example.bank.repository.AccountRepository;

public class ScreenDispatcher {
  public void printMainMenu() {
    System.out.println("\nГлавное меню");
    System.out.println("  1. Мои счета");
    System.out.println("  2. Создать счёт");
    System.out.println("  3. Закрыть программу");
  }

  public void successDeleteMessage(Account account) {
    System.out.println("\nУспешно удалён счёт [" + account.getName() + "]");
  }

  public void nullAccountsMessage() {
    System.out.println("\nСчетов нет");
  }

  public void printAccountsMenu() {
    System.out.println("\nСписок счетов");
  }

  public void accountInfo(Account account) {
    System.out.println(" [ID " + account.getId() + "] " + "[" + account.getName() + "] – " + String.format("%,.2f", account.getBalance()) + " ₽");
  }

  public void printAccountSettingsSection(Account account) {
    System.out.println("\nНастройки аккаунта");
    System.out.println(" [Название]: " + account.getName());
    System.out.println(" [Баланс]: " + String.format("%,.2f", account.getBalance()) + " ₽");
    System.out.println("  1. Изменить название");
    System.out.println("  2. Начислить деньги");
    System.out.println("  3. Снять деньги");
    System.out.println("  4. Удалить счёт");
    System.out.println("  5. Назад");
  }

  public void finishCreateAccount() {
    System.out.println("\nСоздание счёта завершено!");
  }

  public void printAccountSection(String accountName) {
    System.out.println("\nСоздание нового счёта");
    System.out.println(" [Название]: " + accountName);
    System.out.println("  1. Изменить название");
    System.out.println("  2. Завершить");
    System.out.println("  3. Назад");
  }

  public void closeSection() {
    System.out.println("\nЗавершение программы...");
  }

  public void otherSection() {
    System.out.println("\nТакого раздела не существует");
  }
}