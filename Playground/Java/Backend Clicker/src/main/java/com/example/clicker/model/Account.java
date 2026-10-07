package com.example.clicker.model;

public class Account {
  private int balance;
  private int id;

  public Account(int balance, int id) {
    this.balance = balance;
    this.id = id;
  }

  public int getBalance() {
    return balance;
  }

  public int getId() {
    return id;
  }

  public void addBalance() {
    balance++;
  }
}