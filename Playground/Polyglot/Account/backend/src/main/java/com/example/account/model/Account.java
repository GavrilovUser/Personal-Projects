package com.example.account.model;

public class Account {
  private long id;
  private String name;

  public Account(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}