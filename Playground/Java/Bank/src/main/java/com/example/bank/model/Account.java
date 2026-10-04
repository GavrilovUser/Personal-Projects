package com.example.bank.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Account {
  private String name;
  private int id;
  private BigDecimal balance = BigDecimal.ZERO;

  public Account(String name, int id) {
    this.name = Objects.requireNonNull(name, "Название счёта не должно быть null");
    this.id = id;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public void setName(String accountName) {
    name = accountName;
  }

  public void deposit(double value) {
    if (value <= 0) {
      throw new IllegalArgumentException("Значение не может быть негативным или ноль");
    }
    balance = balance.add(BigDecimal.valueOf(value));
  }

  public void withdraw(double value) {
    if (value <= 0) {
      throw new IllegalArgumentException("Значение не может быть негативным или ноль");
    }

    if (balance.compareTo(balance.valueOf(value)) < 0) {
      throw new IllegalStateException("На счету недостаточно средств");
    }
    balance = balance.subtract(BigDecimal.valueOf(value));
  }
}