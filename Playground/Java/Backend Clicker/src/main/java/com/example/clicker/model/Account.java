package com.example.clicker.model;

public class Account {
  private int balance;

  public Account(int balance) {
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  public void addBalance() {
    balance++;
  }
}