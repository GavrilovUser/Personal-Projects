package com.example.bank.util;

import java.util.Scanner;

public class Input {
  private Scanner scanner;

  public Input(Scanner scanner) {
    this.scanner = scanner;
  }
  
  public String readString(String prompt) {
    System.out.print(prompt);
    String line = scanner.nextLine().trim();
    return line;
  }

  public double readDouble(String prompt) {
    while (true) {
      System.out.print(prompt);
      String line = scanner.nextLine().trim();
      try {
        return Double.parseDouble(line);
      } catch (NumberFormatException error) {
        System.out.println(error);
      }
    }
  }
  
  public int readInt(String prompt) {
    while (true) {
      System.out.print(prompt);
      String line = scanner.nextLine().trim();
      try {
        return Integer.parseInt(line);
      } catch (NumberFormatException error) {
        System.out.println(error);
      }
    }
  }
}